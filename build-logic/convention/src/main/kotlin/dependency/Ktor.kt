package dependency

import extension.libs
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension


internal fun Project.configureKtor(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
) {
    kotlinMultiplatformExtension.sourceSets.getByName("commonMain").dependencies {
        api(libs.findLibrary("ktor-client-core").get())
        api(libs.findLibrary("ktor-client-logging").get())
        api(libs.findLibrary("ktor-client-content-negotiation").get())
        api(libs.findLibrary("ktor-serialization-kotlinx-json").get())
    }
    kotlinMultiplatformExtension.sourceSets.getByName("androidMain").dependencies {
        api(libs.findLibrary("ktor-client-okhttp").get())
    }
    kotlinMultiplatformExtension.sourceSets.getByName("iosMain").dependencies {
        api(libs.findLibrary("ktor-client-darwin").get())
    }
}