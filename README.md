# SpaceTraders API - Kotlin Multiplatform

![Maven Central](https://img.shields.io/maven-central/v/com.iamincendium.spacetraders/spacetraders-api)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/com.iamincendium.spacetraders/spacetraders-api?server=https%3A%2F%2Foss.sonatype.org)
![GitHub](https://img.shields.io/github/license/incendium/spacetraders-api)

This project is a Kotlin/Multiplatform wrapper around the [SpaceTraders](https://spacetraders.io) API. It is a 
work-in-progress implementation and is by no means stable. Expect some churn in the near term, especially as the 
SpaceTraders API itself changes and stabilizes.

The goal for this project is to have an easy to use, functional programming-friendly API client which supports most MPP 
targets.  The big goals are to support at least Kotlin/JVM, Kotlin/JS, and Kotlin/WASM.  Contributors are most welcome 
to help implement other targets such as Android, iOS, Native, etc.

## How do I test it out?

This library is currently not published in Maven Central, however, snapshot builds are periodically pushed to Sonatype.
You can access it via the Sonatype snapshots repository:

```kotlin
// build.gradle.kts
repositories {
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation("com.iamincendium.spacetraders:spacetraders-api:0.0.1-SNAPSHOT")
}
```

The first step to utilizing this library is to acquire a token from the API. This can be done via a static method on the
`SpaceTradersAPI` class:

```kotlin
val response = SpaceTradersAPI.register("AGENT-NAME", RegisterRequest.Faction.COSMIC).getOrRethrow()
// response.token

// OR

SpaceTradersAPI.register("AGENT-NAME", RegisterRequest.Faction.COSMIC).onSuccess { /* it.token */ }
```

Once a token has been obtained, the API class can be instantiated with the token and API calls can be performed:

```kotlin
val api = SpaceTradersAPI(token)

// dock all available ships
api.fleet.listShips()
    .getPagedPayloadOrRethrow()
    .forEach { api.fleet.dockShip(it.symbol) }
```

Full KDocs are available [here](https://incendium.github.io/spacetraders-api/).
