Backtrace
===================================================
Backtrace, the sweet hacking sim written in groovy

Building from source
---------------------------------------------------
The build system is Gradle. Gradle does pretty much all the work, just run:

    ./gradlew fatJar

This generates a self contained jar file (dependencies included) in **build/libs/Backtrace-<version>.jar**

If you don't want a fat jar, just run

    ./gradlew build

If you prefer to use your own version of gradle, use any of the above commants but substitute "gradle" for "./gradlew".

Running Unit/Integration tests
---------------------------------------------------

    ./gradlew test

Test reports are located in **build/reports/tests/index.html**

Running the game
----------------------------------------------------
After building the jar, you can run with the java command line:

    java -jar build/libs/build/libs/Backtrace-<version>.jar
