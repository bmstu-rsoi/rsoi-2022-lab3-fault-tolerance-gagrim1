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
    implementation(kotlin("stdlib"))
}