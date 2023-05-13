plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.serialization)
    // alias(libs.plugins.dokka)
    alias(libs.plugins.detekt)
    alias(libs.plugins.versions)
    alias(libs.plugins.versionsFilter)

    idea
}

group = "com.iamincendium.spacetraders"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

detekt {
    ignoreFailures = false

    config = files("${rootDir}/.detekt/config.yml")
    buildUponDefaultConfig = true

    baseline = file("${rootDir}/.detekt/baseline.xml")
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

kotlin {
    explicitApi()

    jvm {
        jvmToolchain(11)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        nodejs()
    }
    // wasm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.serialization.kotlinx.json)

                implementation(libs.kotlinx.coroutines.core)
                api(libs.kotlinx.datetime)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)

                api(libs.michaelBull.kotlin.result)
                api(libs.ionspin.bignum)
                implementation(libs.ionspin.bignumSerializationKotlinx)
                implementation(libs.microutils.kotlinLogging)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.bundles.commonTest.common)
                implementation(libs.ktor.client.mock)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.ktor.client.cio)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.commonTest.jvm)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.client.js)
            }
        }
        // val jsTest by getting
        // val wasmMain by getting
        // val wasmTest by getting
    }
}
