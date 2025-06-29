plugins {
    alias(libs.plugins.android.library.convention)
    alias(libs.plugins.hilt.convention)
}

android {
    namespace = "com.calloop.data.impl"
}

dependencies {
    implementation(project(":data:core"))
    implementation(project(":domain"))
    implementation(project(":core:network"))
}