
buildscript {
    repositories {
        google()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
    }

    dependencies {
        val kotlinVersion = "1.9.22"
        val gradlePlugin = "8.3.0"
        val devtools = "$kotlinVersion-1.0.17"

        classpath("com.android.tools.build:gradle:${gradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${devtools}")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    kotlin("android") version "1.9.22" apply false
}