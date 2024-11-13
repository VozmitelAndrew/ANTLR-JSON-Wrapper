import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker

import java.io.File

import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.*

abstract class JsonWrapperTask : DefaultTask() {
    @Serializable
    data class Stats(val methods: Int, val classes: Int, val interfaces: Int, var lines:Int)

    @get:Input
    abstract val filePath: Property<String>

    @get:Input
    abstract val countRaw: Property<Boolean>

    @TaskAction
    fun apply() {
        val directory = File(filePath.get())

        directory.walk().forEach { file ->
            if (file.isFile) {
                when (file.extension) {
                    "kt" -> {
                        val kotlinStats = analyzeKotlinFile(file)
                        saveJsonFile(file, kotlinStats)
                        println(Json.encodeToString(kotlinStats))
                    }
                    "java" -> {
                        val javaStats = analyzeJavaFile(file)
                        saveJsonFile(file, javaStats)
                        println(Json.encodeToString(javaStats))
                    }
                }
            }
        }


    }

    fun analyzeKotlinFile(file: File): JsonElement {
        val code = file.readText()
        val stats = KotlinFunCounter.countDeclarations(code)
        stats.lines = countLines(file, countRaw.get())

        return Json.encodeToJsonElement(stats)
    }

    fun analyzeJavaFile(file: File): JsonElement {
        val code = file.readText()
        val stats = JavaFunCounter.countDeclarations(code)
        stats.lines = countLines(file, countRaw.get())
        return Json.encodeToJsonElement(stats)
    }


    fun countLines(file: File, countRaw: Boolean): Int {
        return if (countRaw) {
            file.readLines().size
        } else {
            file.readLines().count { line ->
                line.isNotBlank() && !line.trim().startsWith("//") && !line.trim().startsWith("/*")
            }
        }
    }

    object KotlinFunCounter {

        fun countDeclarations(code: String): Stats{
            val lexer = KotlinLexer(CharStreams.fromString(code))
            lexer.removeErrorListeners()
            val tokens = CommonTokenStream(lexer).apply { fill() }

            val funCount = tokens.tokens.count { (it.type == KotlinLexer.FUN) }
            val classCount = tokens.tokens.count { (it.type == KotlinLexer.CLASS) }
            val interfaceCount = tokens.tokens.count { (it.type == KotlinLexer.INTERFACE) }

            return Stats(funCount, classCount, interfaceCount, 0)
        }

    }

    class JavaDeclarationCounter : JavaBaseListener() {
        var methodCount = 0
        var classCount = 0
        var interfaceCount = 0

        override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext) {
            methodCount++
        }

        override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext) {
            classCount++
        }

        override fun enterInterfaceDeclaration(ctx: JavaParser.InterfaceDeclarationContext) {
            interfaceCount++
        }
    }

    object JavaFunCounter {
        fun countDeclarations(code: String): Stats {
            val lexer = JavaLexer(CharStreams.fromString(code))
            lexer.removeErrorListeners()
            val tokens = CommonTokenStream(lexer)
            val parser = JavaParser(tokens)
            val tree = parser.compilationUnit()

            val declarationCounter = JavaDeclarationCounter()
            ParseTreeWalker.DEFAULT.walk(declarationCounter, tree)

            return Stats(declarationCounter.methodCount, declarationCounter.classCount, declarationCounter.interfaceCount, 0)
        }
    }

    fun saveJsonFile(file: File, json: JsonElement) {
        val outputFile = File("${file.path}.${file.name}.json")
        outputFile.parentFile.mkdirs()
        outputFile.writeText(json.toString())
    }
}


tasks.register<JsonWrapperTask>("generateStats") {
    group = "Custom plugin"
    description = "Generates a json for each file and outputs in src/parsed  Parametres: directory, raw"
    filePath.set(properties["directory"]?.toString() ?: "src/main/")
    countRaw.set(properties["raw"]?.toString()?.toBoolean() ?: true)
}

