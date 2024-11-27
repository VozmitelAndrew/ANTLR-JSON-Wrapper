import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

@Serializable
data class Stats(val methods: Int, val classes: Int, val interfaces: Int, var lines: Int)

fun countLines(file: File, countRaw: Boolean): Int {
    return if (countRaw) {
        file.readLines().size
    } else {
        file.readLines().count { line ->
            line.isNotBlank() && !line.trim().startsWith("//") && !line.trim().startsWith("/*")
        }
    }
}

fun analyzeKotlinFile(file: File, countRaw: Boolean): JsonElement {
    val code = file.readText()
    val stats = KotlinFunCounter.countDeclarations(code)
    stats.lines = countLines(file, countRaw)

    return Json.encodeToJsonElement(stats)
}

object KotlinFunCounter {

    fun countDeclarations(code: String): Stats {
        val lexer = KotlinLexer(CharStreams.fromString(code))
        lexer.removeErrorListeners()
        val tokens = CommonTokenStream(lexer).apply { fill() }

        val funCount = tokens.tokens.count { (it.type == KotlinLexer.FUN) }
        val classCount = tokens.tokens.count { (it.type == KotlinLexer.CLASS) }
        val interfaceCount = tokens.tokens.count { (it.type == KotlinLexer.INTERFACE) }

        return Stats(funCount, classCount, interfaceCount, 0)
    }

}