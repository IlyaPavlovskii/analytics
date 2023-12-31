plugins {
    id("multiplatform-library-convention")
    id("publish-library-convention")
}
android {
    namespace = "io.github.ilyapavlovskii.kmm.analytics"
}
dependencies {
    androidMainImplementation(platform(libs.firebase.bom))
    androidMainImplementation(libs.firebase.analytics.ktx)
    androidMainImplementation(libs.com.facebook.android.core)

    commonMainImplementation(libs.koin.core)
}
