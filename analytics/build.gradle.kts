plugins {
    id("multiplatform-library-convention")
    id("publish-library-convention")
}
android {
    namespace = "io.github.ilyapavlovskii.kmm.analytics"
}
dependencies {
    commonMainImplementation(libs.koin.core)
}
