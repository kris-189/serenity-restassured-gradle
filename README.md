# Testing Assignment for Backend API
Project using tools like: Java, Gradle, Serenity BDD, RestAssured and JUnit5

## Start project locally:
```
./gradlew clean test
```

## Most recent Serenity report can be seen on:
https://kris-189.github.io/serenity-restassured-gradle/

## Command to publish report:
```
./gradlew clean test copyReport
```
This command will run tests and copy report files to /docs folder. 
After pushing the changes to GitHub, the Serenity Report can be seen on web mentioned earlier.