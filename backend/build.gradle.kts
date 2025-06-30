import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

ext["spring-framework.version"] = "7.0.0-SNAPSHOT"

plugins {
    val springBootVersion = "4.0.0-SNAPSHOT"
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.serialization")
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(project(":shared"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-cache")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(libs.kotlinx.html.jvm)
    implementation(libs.kotlinx.serialization.json)
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
}
