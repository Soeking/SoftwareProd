plugins {
    id("java")
    application
}

group
version

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.12")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.java-websocket:Java-WebSocket:1.5.1")
}

application {
    mainClassName = "Main"
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "application")
    repositories {
        mavenCentral()
    }
    dependencies {
        implementation("com.google.code.gson:gson:2.8.6")
        implementation("org.java-websocket:Java-WebSocket:1.5.1")
    }
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "Main"
    }

    from(
            configurations.compile.get().map {
                if (it.isDirectory) it else zipTree(it)
            }
    )
    exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
}

val run by tasks.getting(JavaExec::class) {
    if (project.hasProperty("args")) {
        args = (project.property("args") as String).split("\\s+")
    }
}

project(":server") {
    application {
        mainClassName = "Server"
    }

    val run by tasks.getting(JavaExec::class) {
        if (project.hasProperty("args")) {
            args = (project.property("args") as String).split("\\s+")
        }
    }
}