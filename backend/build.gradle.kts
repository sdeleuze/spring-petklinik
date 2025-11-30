import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    val springBootVersion = "4.0.0"
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.serialization")
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(project(":shared"))

    implementation("org.springframework.boot:spring-boot-starter-webmvc") {
        exclude("org.springframework.boot:spring-boot-starter-jackson")
    }
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-restclient")
    implementation("org.springframework.boot:spring-boot-kotlinx-serialization-json")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(libs.kotlinx.html.jvm)
    implementation(libs.konform)

    runtimeOnly("org.postgresql:postgresql")

    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    processResources {
        dependsOn(":frontend:wasmJsBrowserDistribution")
        from(project(":frontend").layout.buildDirectory
            .dir("dist/wasmJs/productionExecutable")) {
            into("static")
        }
    }
}

tasks.named<BootBuildImage>("bootBuildImage") {
    environment.put("BP_JVM_CDS_ENABLED", "true")
    environment.put("BP_JVM_VERSION", "25")
}

kotlin {
    jvmToolchain(17)
}