plugins {
    id("dev.fritz2.fritz2-gradle") version "0.11"
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("dev.fritz2:core:0.11")
                implementation("dev.fritz2:components:0.11")
            }
        }
        val jsMain by getting
        all {
            languageSettings.useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
            languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
        }
    }
}