import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * To learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.6/samples
 */



buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlinx","kotlinx-serialization-json",libs.versions.kotlinxSerializationVersion.get())
        classpath("com.google.code.gson","gson",libs.versions.gsonVersion.get())
    }
}

tasks.register("sayHelloWorld") {
    doFirst {
        logger.info("Hello world!")
    }
}


tasks.register<Copy>("copyTaskSample") {
    doFirst {
        logger.info("copyTaskSample started!")
    }
    from("file.txt")
    into("build")
    doLast {
        logger.info("Finished copying")
    }
}

tasks.register<Exec>("sleepTask") {
    workingDir(".")
    if (System.getProperty("os.name").startsWith("Windows")) {
        commandLine("cmd", "/c", "timeout", "/t", "1")
    } else {
        commandLine("sleep", "1")
    }
    dependsOn("copyTaskSample")
}


val gson: Gson = GsonBuilder().setPrettyPrinting().create()
tasks.register("readJSONFile") {
    doLast {
        val jsonContent = File("data.json").readText()
        val mapType = object : TypeToken<Map<String, Any>>() {}.type
        val map: Map<String, Any> = gson.fromJson(jsonContent, mapType)
        logger.info("read json file $map")
    }
}


tasks.getByName("readJSONFile") { dependsOn("sleepTask") }