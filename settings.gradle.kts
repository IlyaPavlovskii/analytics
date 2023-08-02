@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

//rootProject.name = "KoinUtils"
includeBuild("build-logic")
include(":analytics")
//include(":koin-utils")
