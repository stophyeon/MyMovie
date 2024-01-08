FROM openjdk:17-jdk-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} movies-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/movies-0.0.1-SNAPSHOT.jar"]