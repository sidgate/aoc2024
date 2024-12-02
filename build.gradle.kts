plugins {
    kotlin("jvm") version "2.0.20"
}

group = "sidgate"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(22)
}
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}