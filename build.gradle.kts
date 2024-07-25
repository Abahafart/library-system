plugins {
    java
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.hibernate.orm") version "6.5.2.Final"
    id("org.graalvm.buildtools.native") version "0.10.2"
    id("org.cyclonedx.bom") version "1.8.2"
    id("jacoco")
}

group = "com.mistborn"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka")
    compileOnly("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:${property("mapstructVersion")}")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:${property("mapstructVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.cloud:spring-cloud-stream-test-binder")
    testImplementation("org.jeasy:easy-random-core:${property("easyRandomVersion")}")
    testImplementation("com.tngtech.archunit:archunit-junit5:${property("archunitVersion")}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("jupiterApiVersion")}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

springBoot() {
    mainClass.set("com.mistborn.library.system.Application")
}

hibernate {
    enhancement {
        enableAssociationManagement = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
    classDirectories.setFrom(files(classDirectories.files.map {
        fileTree(it) {
            exclude("**/domain/**")
        }
    }))
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.0".toBigDecimal() // Umbral mínimo de cobertura del 00%
            }
        }
    }
    classDirectories.setFrom(files(classDirectories.files.map {
        fileTree(it) {
            exclude("**/event/domain/**")
        }
    }))
}

tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}

graalvmNative {
    binaries {
        named("main") {
            buildArgs.add("-H:+UnlockExperimentalVMOptions")
            buildArgs.add("-H:ServiceLoaderFeatureExcludeServices=org.hibernate.bytecode.spi.BytecodeProvider")
            buildArgs.add("-H:ReflectionConfigurationResources=META-INF/native-image/org.apache.tomcat.embed/tomcat-embed-websocket/tomcat-reflection.json")
            buildArgs.add("-H:ReflectionConfigurationResources=META-INF/native-image/org.apache.tomcat.embed/tomcat-embed-el/tomcat-reflection.json")
            buildArgs.add("-H:ResourceConfigurationResources=META-INF/native-image/org.apache.tomcat.embed/tomcat-embed-core/tomcat-resource.json")
            buildArgs.add("-H:ReflectionConfigurationResources=META-INF/native-image/org.apache.tomcat.embed/tomcat-embed-core/tomcat-reflection.json")
            buildArgs.add("-H:ResourceConfigurationResources=META-INF/native-image/org.apache.tomcat.embed/tomcat-embed-el/tomcat-resource.json")
            buildArgs.add("-H:ResourceConfigurationResources=META-INF/native-image/org.apache.tomcat.embed/tomcat-embed-websocket/tomcat-resource.json")
        }
    }
}
