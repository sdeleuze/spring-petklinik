allprojects {
    group = "io.spring"
    version = "1.0.0-SNAPSHOT"
}

plugins {
    val kotlinVersion = "2.2.0"
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.serialization") version kotlinVersion apply false
}
