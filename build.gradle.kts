plugins {
    id("java")
    id("net.serenity-bdd.serenity-gradle-plugin") version "5.3.9"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("net.serenity-bdd:serenity-core:5.3.10")
    testImplementation("net.serenity-bdd:serenity-rest-assured:5.3.10")
    testImplementation("net.serenity-bdd:serenity-junit5:5.3.10")
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.0")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy("aggregate")
}