import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.File


fun analyzeJavaFile(file: File, countRaw: Boolean): JsonElement {
    val code = file.readText()
    val stats = JavaFunCounter.countDeclarations(code)
    stats.lines = countLines(file, countRaw)
    return Json.encodeToJsonElement(stats)
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

        return Stats(
            declarationCounter.methodCount,
            declarationCounter.classCount,
            declarationCounter.interfaceCount,
            0
        )
    }
}
