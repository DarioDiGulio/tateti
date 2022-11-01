import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar


plugins {
    kotlin("jvm") version "1.7.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.upward"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform { }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.getByName<ShadowJar>("shadowJar") {
    archiveFileName.set("liquidator_api.jar")
    manifest {
        attributes(mapOf(
            "Main-Class" to "com.upward.tateti.code.MainKt",
            "VERSION" to project.version
        ))
    }
}

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDirs("src", "generated")
        resources.srcDirs("resources")
    }
    sourceSets["test"].apply {
        kotlin.srcDir("test")
        resources.srcDir("test_resources")
    }
}

java {
    sourceSets["main"].apply {
        java.srcDirs("src", "generated")
        resources.srcDirs("resources")
    }
    sourceSets["test"].apply {
        java.srcDir("test")
        resources.srcDir("test_resources")
    }
}