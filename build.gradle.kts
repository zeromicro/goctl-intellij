import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("java")
    id("org.jetbrains.changelog")
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.intellij.platform.grammarkit")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

sourceSets {
    main {
        java {
            srcDir(tasks.generateLexer.flatMap { it.targetRootOutputDir })
            srcDir(tasks.generateParser.flatMap { it.targetRootOutputDir })
        }
    }
}

tasks.generateLexer {
    sourceFile = file("src/main/java/cn/xiaoheiban/Api.flex")
    targetRootOutputDir = layout.buildDirectory.dir("generated/api-lexer")
    pathToClass = "cn/xiaoheiban/ApiLexer.java"
}

tasks.generateParser {
    sourceFile = file("src/main/java/cn/xiaoheiban/Api.bnf")
    targetRootOutputDir = layout.buildDirectory.dir("generated/api-parser")
    pathToParser = "cn/xiaoheiban/parser/ApiParser.java"
    pathToPsiRoot = "cn/xiaoheiban/psi"
}

tasks.compileJava {
    dependsOn(tasks.generateLexer, tasks.generateParser)
}

// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    testImplementation(libs.junit)

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        val localPlatform = providers.gradleProperty("localPlatformPath").orNull
        if (localPlatform != null) {
            local(localPlatform)
        } else {
            goland("2026.2.0.1")
        }
        testFramework(TestFrameworkType.Platform)

        // Add plugin dependencies for compilation here, for example:
        bundledPlugin("org.jetbrains.plugins.go")
    }
}
