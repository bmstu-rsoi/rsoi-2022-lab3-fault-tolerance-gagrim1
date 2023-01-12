plugins {
    kotlin("jvm")
    id("java-library")
}

group = "io.romanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":bonus-service-api"))

    implementation(kotlin("stdlib"))
}
