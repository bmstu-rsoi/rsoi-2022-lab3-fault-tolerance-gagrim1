plugins {
    kotlin("jvm")
}

group = "io.romanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":ticket-service-api"))
    implementation(project(":bonus-service-api"))

    implementation(kotlin("stdlib"))
}