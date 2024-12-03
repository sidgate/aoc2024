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
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}

tasks.test {
    useJUnitPlatform()
}