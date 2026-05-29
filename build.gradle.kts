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
    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")
    testCompileOnly("org.projectlombok:lombok:1.18.46")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.46")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy("aggregate")
}

tasks.register<Copy>("copyReport") {
    dependsOn("aggregate")
    from("target/site/serenity")
    into("docs")
}