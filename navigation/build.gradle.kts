plugins {
    alias(libs.plugins.android.library.convention)
    alias(libs.plugins.compose.convention)
}

android {
    namespace = "com.calloop.navigation"
}

dependencies {
    implementation(project(":core:ui"))
}