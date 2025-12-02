package configuration

import com.android.build.api.dsl.CommonExtension
import configuration.ProjectConfig.JVM_TARGET
import configuration.utils.javaTargetVersion
import extension.COMPILE_SDK
import extension.MIN_SDK
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = COMPILE_SDK

        defaultConfig {
            minSdk = MIN_SDK
        }

        compileOptions {
            sourceCompatibility = javaTargetVersion
            targetCompatibility = javaTargetVersion
        }
    }

    configureKotlin()
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JVM_TARGET)
        }
    }
}