plugins {
    alias(libs.plugins.android.application.convention)
    alias(libs.plugins.hilt.convention)
    alias(libs.plugins.compose.convention)
}

android {
    namespace = "com.calloop.app"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data:impl"))
    implementation(project(":navigation"))
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
    implementation(project(":core:network"))
}