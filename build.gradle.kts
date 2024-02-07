plugins {
    `java-library`
    `maven-publish`
    checkstyle
    alias(libs.plugins.shadow)
    alias(libs.plugins.blossom)
    alias(libs.plugins.run.velocity)
    alias(libs.plugins.spotless)
}

val group = property("group") as String
// Indicates the version string for the current branch.
val version = property("version") as String

tasks {
    build {
        dependsOn(shadowJar)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
    }
    spotless {
        java {
            licenseHeaderFile(rootProject.file("HEADER.txt"))
        }
    }
    checkstyle {
        configFile = rootProject.file("config/checkstyle/checkstyle.xml")
        maxErrors = 0
        maxWarnings = 0
        toolVersion = libs.checkstyle.get().version.toString()
    }
    runVelocity {
        velocityVersion(libs.versions.velocity.get())
    }
}

blossom {
    replaceToken("{version}", version, "src/main/java/me/qeklydev/template/Constants.java")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

dependencies {
    compileOnly(libs.velocity)
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}
