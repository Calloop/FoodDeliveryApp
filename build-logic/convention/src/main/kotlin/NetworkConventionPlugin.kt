import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class NetworkConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target)
        {
            with(pluginManager) {
                {
                }

                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

                dependencies {
                    add(
                        "implementation",
                        libs.findLibrary("retrofit").get()
                    )
                    add(
                        "implementation",
                        libs.findLibrary("okhttp").get()
                    )
                    add(
                        "implementation",
                        libs.findLibrary("okhttp-logging").get()
                    )
                }
            }
        }
    }
}