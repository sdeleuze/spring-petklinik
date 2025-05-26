<img src="spring-petklinik.png" width="50%" height="50%">

Spring Petklinik is a Kotlin fullstack variant of the original [Spring Petclinic](https://github.com/spring-projects/spring-petclinic) with Kotlin.

## Architecture

<img src="architecture.png">

Key characteristics:
 - [Kotlin/Wasm](https://kotlinlang.org/docs/wasm-overview.html) for the frontend instead of JavaScript or TypeScript
 - Most of the rendering is still done on server-side, but some dynamic parts are implemented on client-side (validation or dynamic update of some pages like the owner search result)
 - [Kotlin multiplatform support](https://kotlinlang.org/docs/multiplatform.html) to share code between Kotlin/Wasm and Kotlin/JVM using a shared module
 - Preview of Spring Boot 4 and Spring Framework 7 with its new [bean registration DSL](https://docs.spring.io/spring-framework/reference/7.0/core/beans/java/programmatic-bean-registration.html) combined with the [web router DSL](https://docs.spring.io/spring-framework/reference/7.0-SNAPSHOT/languages/kotlin/web.html#router-dsl)
 - [kotlinx.html](https://github.com/Kotlin/kotlinx.html) for type-safe template rendering (hopefully later replaced by a first class [Compose HTML](https://github.com/JetBrains/compose-multiplatform/blob/master/tutorials/HTML/Building_UI/README.md) support)
 - Virtual Threads
 - OpenAI interactions implemented in a distinct application based on Spring AI
 - [CDS Buildpack support](https://docs.spring.io/spring-boot/how-to/class-data-sharing.html) used to speedup containers startup 

## Requirements

  - Java 24+ (can be installed via [SDKMAN!](https://sdkman.io/))
  - [Docker](https://www.docker.com/)
  - Optional: an [OpenAI](https://openai.com/) key for the image generation service

## Getting started

To run just the Petklinik application in development mode:
 - Run `./gradlew :backend:bootRun`
 - Go to `http://localhost:8080`

To run all services in production mode:
 - Run `./gradlew clean build bootBuildImage`
 - Define an `OPENAI_API_KEY` environment variable
 - Run `docker compose --profile all up`
 - Go to `http://localhost:8080`
