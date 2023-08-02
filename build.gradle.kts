buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath(libs.plugin.kotlin.gradle)
        classpath(libs.plugin.android.gradle)
        classpath(":build-logic")
    }
}

plugins {
    id("configuration-detekt-convention")
}

subprojects {
    apply(plugin = "configuration-ktlint-convention")
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    group = "io.github.ilyapavlovskii.kmm.koin"
    version = "2023.02.13"

    setupJavaTarget(this)
}

fun setupJavaTarget(project: Project) {
    project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
    project.tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        targetCompatibility = JavaVersion.VERSION_11.toString()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
