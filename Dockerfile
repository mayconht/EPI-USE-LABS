# Use the official maven/Java 17 image to build a release artifact.
FROM maven:3.8.3-openjdk-17 as builder
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -e -B dependency:resolve -DskipTests
COPY src ./src
RUN mvn -e -B package -DskipTests
#the focus is show the spring boot app, not the tests

FROM openjdk:17-slim-buster
WORKDIR /app
COPY --from=builder /usr/src/app/target/Poker-1.0-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "spring"]
