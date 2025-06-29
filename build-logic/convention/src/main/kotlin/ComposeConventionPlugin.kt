import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            project.extensions.configure<CommonExtension<*, *, *, *, *, *>>("android") {
                buildFeatures.compose = true
                composeOptions {
                    kotlinCompilerExtensionVersion =
                        libs.findVersion("composeCompiler").get().toString()
                }
            }

            dependencies {
                add(
                    "implementation",
                    libs.findLibrary("androidx-compose-ui").get()
                )
                add(
                    "implementation",
                    libs.findLibrary("androidx-compose-material3").get()
                )
                add(
                    "implementation",
                    libs.findLibrary("androidx-navigation-compose").get()
                )
                add(
                    "implementation",
                    libs.findLibrary("androidx-activity-compose").get()
                )
            }
        }
    }
}