FROM maven:3.8.3-openjdk-17 as builder
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package


FROM openjdk:17-slim-buster
WORKDIR /app
COPY --from=builder /usr/src/app/target/Poker-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "spring"]
