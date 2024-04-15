# public-gradle-tutorial

### 1. setup 
Run `./gradlew` to set up gradle. You just have to have java installed.
 `gradle init` initialises a gradle setup. This requires gradle is installed.

### 2. list all tasks available
You can list tasks with: `./gradlew tasks --all`

Most editors have support for running tasks, and showing tasks.

### 3. creating tasks can be done with: `tasks.register()`
like:
```kotlin
tasks.register("sayHelloWorld") {
    doFirst {
        logger.info("Hello world!")
    }
}
```

### 4. copy files
Copying files can be done with the task:
`./gradlew copyTaskSample`

Here is a sample of a copy task:
```kotlin
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
```

This is in build.gradle.kts, and you can see the task with `./gradlew tasks --all`.

### 5. dependency on other tasks can normally be done with either: `depends_on`

Here is an example:
```kotlin
tasks.getByName("readJSONFile") { dependsOn("sleepTask") } 
```

### 6. reading a JSON file
To read a json file see task:
`./gradlew readJSONFile`

7. run groovy scripts

8. run tasks in parallel
