val context = "myapp"
val servletVersion: String by project
val jstlVersion: String by project
val junitVersion: String by project
val log4jVersion: String by project

plugins {
    java
    war
    id("com.bmuschko.cargo") version "2.9.0"
}

group = "com.myapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
tasks.war {
    this.archiveFileName.set("${context}.war")
}

dependencies {
    compileOnly("jakarta.servlet:jakarta.servlet-api:${servletVersion}")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:${jstlVersion}")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:${jstlVersion}")
    implementation("org.apache.logging.log4j:log4j-core:${log4jVersion}")
    implementation("org.apache.logging.log4j:log4j-api:${log4jVersion}")
    implementation("org.apache.logging.log4j:log4j-jakarta-web:${log4jVersion}")


    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

cargo {
    containerId = "tomee9x"
    port = 8080

    withGroovyBuilder {
        "deployable" {
            "setContext"("$context")
        }

        "remote" {
            "setHostname"("localhost")

            "setUsername"("tomee")
            "setPassword"("tomee")
        }
    }
}