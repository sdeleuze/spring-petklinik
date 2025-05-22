<img src="spring-petklinik.png" width="50%" height="50%">

Spring Petklinik is a Kotlin fullstack variant of the typical [Spring Petclinic](https://github.com/spring-projects/spring-petclinic) example with Kotlin/Wasm for the frontend instead of JavaScript or TypeScript.

This project leverages [Kotlin multiplatform support](https://kotlinlang.org/docs/multiplatform.html) to share code between Wasm and JVM using a shared module.

To run just the Petklinik application:
 - Run the `postgres` database from the `docker-compose.yml` file.
 - Run `./gradlew bootRun`.
 - Go to `http://localhost:8080`.

To run both Petklinik and the AI image generation service:
 - Run `./gradlew clean build bootBuildImage`.
 - Define an `OPENAI_API_KEY` environment variable.
 - Run `docker-compose up`.
 - Go to `http://localhost:8080`.
