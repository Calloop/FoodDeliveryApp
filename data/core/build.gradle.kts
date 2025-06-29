plugins {
    alias(libs.plugins.android.library.convention)
    alias(libs.plugins.room.convention)
    alias(libs.plugins.network.convention)
}

android {
    namespace = "com.calloop.data.core"
}

dependencies {
    implementation(project(":domain"))
}