plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.serialization)
    alias(libs.plugins.dokka)
    alias(libs.plugins.detekt)
    alias(libs.plugins.versions)
    alias(libs.plugins.versionsFilter)
    alias(libs.plugins.credentials)

    `maven-publish`
    signing
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
                // api(libs.ionspin.bignum)
                // implementation(libs.ionspin.bignumSerializationKotlinx)
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
                implementation(libs.slf4j.api)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.commonTest.jvm)
                implementation(libs.slf4j.simple)
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

val credentials: nu.studer.gradle.credentials.domain.CredentialsContainer by project.extra
val ossrhUsername: String? = System.getenv("OSSRH_USERNAME") ?: credentials.forKey("ossrhUsername")
val ossrhPassword: String? = System.getenv("OSSRH_PASSWORD") ?: credentials.forKey("ossrhPassword")
val signingKeyPath: String? = System.getenv("SIGN_KEY_PATH") ?: credentials.forKey("signingKeyPath")
val signingPassword: String? = System.getenv("SIGN_PASSWORD") ?: credentials.forKey("signingPassword")

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("spacetraders-api")
            description.set("A Kotlin-based wrapper for the SpaceTraders API.")
            url.set("https://github.com/incendium/space-traders-api")

            licenses {
                license {
                    name.set("ISC License")
                    url.set("https://spdx.org/licenses/ISC.html")
                }
            }

            developers {
                developer {
                    id.set("incendium")
                    name.set("Matthew Gast")
                    email.set("incendium@gmail.com")
                }
            }

            scm {
                url.set("https://github.com/incendium/spacetraders-api")
                connection.set("scm:git:https://github.com/incendium/spacetraders-api.git")
                developerConnection.set("scm:git:https://github.com/incendium/spacetraders-api.git")
            }
        }
    }

    repositories {
        maven {
            name = "ossrhSnapshots"
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")

            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }

        maven {
            name = "ossrhStaging"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")

            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}

signing {
    if (signingKeyPath != null) {
        useInMemoryPgpKeys(signingKeyPath, signingPassword)
    } else {
        useGpgCmd()
    }
    publishing.publications.forEach { sign(it) }
}

tasks.build {
    dependsOn(tasks.detektMetadataMain)
}
