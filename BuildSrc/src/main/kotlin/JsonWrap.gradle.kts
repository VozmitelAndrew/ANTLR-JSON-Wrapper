import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.io.File

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.nio.file.Paths

abstract class JsonWrapperTask : DefaultTask() {
    @get:Input
    abstract val filePath: Property<String>

    @get:Input
    abstract val countRaw: Property<Boolean>

    @TaskAction
    fun apply() {
        val projectBasePath = System.getProperty("user.dir")
        val directory = Paths.get("$projectBasePath${File.separator}${filePath.get()}")
        directory.toFile().walk().forEach { file ->
            //println(file.name)
            if (file.isFile) {
                when (file.extension) {
                    "kt" -> {
                        val kotlinStats = analyzeKotlinFile(file, countRaw.get())
                        saveJsonFile(file, kotlinStats)
                        println("${file.name}: ${Json.encodeToString(kotlinStats)}")
                    }

                    "java" -> {
                        val javaStats = analyzeJavaFile(file, countRaw.get())
                        saveJsonFile(file, javaStats)
                        println("${file.name}: ${Json.encodeToString(javaStats)}")
                    }
                }
            }
        }

        mergeJson(File("$projectBasePath${File.separator}parsed"))
    }

    fun saveJsonFile(file: File, json: JsonElement) {

        val updatedPath = file.absolutePath.replaceFirst(filePath.get(), "parsed")
        //println("Updated relative path: $updatedPath")
        val parentDir = File(updatedPath).parentFile

        //println("Parent directory absolute path: ${parentDir.absolutePath}")

        if (!parentDir.exists()) {
            parentDir.mkdirs()
            println("Directories created: ${parentDir.absolutePath}")
        }

        val outputFile = File(parentDir.absolutePath, "${file.name.substringBeforeLast(".")}.json")

        //println("Parent directory absolute path: ${file.name}")
        //println("Parent directory absolute path: ${outputFile.absolutePath}")

        // Записываем в файл (если нужно)
        outputFile.writeText(json.toString())
    }

    fun mergeJson(fileToMerge: File) {
        var totalMethods = 0
        var totalClasses = 0
        var totalInterfaces = 0
        var totalLines = 0

        fileToMerge.walk().forEach { file ->
            if (file.isFile && file.extension == "json") {
                val jsonElement = Json.parseToJsonElement(file.readText()).jsonObject
                totalMethods += jsonElement["methods"]?.jsonPrimitive?.int ?: 0
                totalClasses += jsonElement["classes"]?.jsonPrimitive?.int ?: 0
                totalInterfaces += jsonElement["interfaces"]?.jsonPrimitive?.int ?: 0
                totalLines += jsonElement["lines"]?.jsonPrimitive?.int ?: 0
            }
        }

        val mergedJson = JsonObject(
            mapOf(
                "totalMethods" to JsonPrimitive(totalMethods),
                "totalClasses" to JsonPrimitive(totalClasses),
                "totalInterfaces" to JsonPrimitive(totalInterfaces),
                "totalLines" to JsonPrimitive(totalLines)
            )
        )

        // Сохраняем объединенный результат в файл merged.json
        val mergedFile = File("$fileToMerge${File.separator}merged.json")
        println("Merged: $mergedJson")
        mergedFile.writeText(mergedJson.toString())
        //println("Merged JSON saved to: ${mergedFile.absolutePath}")
    }
}


tasks.register<JsonWrapperTask>("generateStats") {
    group = "Custom plugin"
    description = "Generates a json for each file and outputs in src/parsed  Parametres: directory, countRawLines"
    filePath.set(properties["directory"]?.toString() ?: "src${File.separator}main")
    countRaw.set(properties["countRawLines"]?.toString()?.toBoolean() ?: true)
}

