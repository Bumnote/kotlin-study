plugins {
    kotlin("jvm") version "2.3.21"
    kotlin("plugin.spring") version "2.3.21"
    id("org.springframework.boot") version "4.1.0"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "2.3.21"
}

group = "com.laboratory"
version = "0.0.1-SNAPSHOT"
description = "payment"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2025.1.2"

dependencies {

    // Web
    implementation("org.springframework.boot:spring-boot-starter-webmvc")

    // H2
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-h2console")

    // Spring Data JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Open Feign -> FeignClient
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // Reflect
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Jackson
    implementation("tools.jackson.module:jackson-module-kotlin")

    // Logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.3")

    // Test
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
