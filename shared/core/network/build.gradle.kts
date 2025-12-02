plugins {
    alias(libs.plugins.build.logic.library)
    alias(libs.plugins.build.logic.kotlin.multiplatform)
    alias(libs.plugins.build.logic.ktor)
    alias(libs.plugins.apollo)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.model)

            //Koin
            api(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)

            //Logger
            implementation(libs.napier)

            implementation(libs.kotlinx.serialization.json)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(kotlin("test-annotations-common"))

            implementation(libs.mockito.kotlin)
            implementation(libs.robolectric)
        }
    }
}

android {
    namespace = "com.fomart.spx.core.network"
}