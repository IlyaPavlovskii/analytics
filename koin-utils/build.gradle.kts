plugins {
    id("multiplatform-library-convention")
    id("publish-library-convention")
}
android {
    namespace = "io.github.ilyapavlovskii.kmm.koin"
}
dependencies {
    commonMainImplementation(libs.koin.core)
}
