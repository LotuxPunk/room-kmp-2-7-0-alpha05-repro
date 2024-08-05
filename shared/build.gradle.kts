import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.androidx.room.room.gradle.plugin)
    alias(libs.plugins.com.google.devtools.ksp)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }

        commonMain.dependencies {
            implementation(libs.org.jetbrains.kotlin.kotlinx.coroutines.core)
            implementation(libs.androidx.room.room.runtime)
            implementation(libs.androidx.sqlite.sqlite.bundled)
        }

        iosMain {
            // Fixes RoomDB Unresolved reference 'instantiateImpl' in iosMain
            kotlin.srcDir("build/generated/ksp/metadata")
        }
    }
}

android {
    namespace = "be.vandeas.morceau.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

dependencies {
//    ksp(libs.androidx.room.room.compiler)
    annotationProcessor(libs.androidx.room.room.compiler)
    add("kspCommonMainMetadata", libs.androidx.room.room.compiler)
    add("kspAndroid", libs.androidx.room.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.room.compiler)
    add("kspIosX64", libs.androidx.room.room.compiler)
    add("kspIosArm64", libs.androidx.room.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata" ) {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}
