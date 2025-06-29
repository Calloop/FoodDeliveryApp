plugins {
    alias(libs.plugins.android.feature.convention)
}

android {
    namespace = "com.calloop.feature.home"
}

dependencies {
    implementation(project(":core:ui"))
}