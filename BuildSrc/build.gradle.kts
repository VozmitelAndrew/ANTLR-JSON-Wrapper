group = "JsonWrapper"
version = "1.0.0"


//gradlePlugin {
//    plugins {
//        register("generateStats") {
//            id = "generateStats"
//            group = "custom_plugin"
//            implementationClass = "JsonWrapperTask"
//        }
//    }
//}

//gradlePlugin {
//    plugins {
//        create("my-binary-plugin") {
//            id = "com.example.my-binary-plugin"
//            implementationClass = "MyCreateFileBinaryPlugin"
//        }
//    }
//}


plugins {
    `kotlin-dsl`
    kotlin("jvm") version "2.0.10"
    antlr
    kotlin("plugin.serialization") version "2.0.10"
}

dependencies {
    api(kotlin("stdlib"))
    antlr("org.antlr:antlr4:4.13.2")
}

sourceSets {
    main {
        java.srcDirs("src/main/java", "src/main/java/antlr4")
        kotlin.srcDirs("src/main/kotlin")
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(kotlin("test"))
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
}


kotlin {
    jvmToolchain(21)
}