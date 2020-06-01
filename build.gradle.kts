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
    //testCompile group: 'junit', name: 'junit', version: '4.12'
    implementation("com.google.code.gson:gson:2.8.6")
}

application {
    mainClassName = "Main"
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