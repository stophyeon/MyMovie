FROM openjdk:17-oracle
WORKDIR /app
ARG JAR_FILE=build/libs/config-server.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]