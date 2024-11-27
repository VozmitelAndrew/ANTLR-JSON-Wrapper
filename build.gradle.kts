plugins {
    kotlin("jvm") version "2.0.10"
    id("JsonWrap")
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.build {
    dependsOn(tasks.named("generateStats"))
}

kotlin {
    jvmToolchain(21)
}

