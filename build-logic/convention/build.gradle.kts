plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.room.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(libs.hilt.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("android-application-convention") {
            id = libs.plugins.android.application.convention.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("android-library-convention") {
            id = libs.plugins.android.library.convention.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("android-feature-convention") {
            id = libs.plugins.android.feature.convention.get().pluginId
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("compose-convention") {
            id = libs.plugins.compose.convention.get().pluginId
            implementationClass = "ComposeConventionPlugin"
        }
        register("hilt-convention") {
            id = libs.plugins.hilt.convention.get().pluginId
            implementationClass = "HiltConventionPlugin"
        }
        register("network-convention") {
            id = libs.plugins.network.convention.get().pluginId
            implementationClass = "NetworkConventionPlugin"
        }
        register("room-convention") {
            id = libs.plugins.room.convention.get().pluginId
            implementationClass = "RoomConventionPlugin"
        }
    }
}