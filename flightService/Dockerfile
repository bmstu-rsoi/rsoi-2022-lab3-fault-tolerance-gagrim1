FROM openjdk:18-jdk-alpine
RUN mkdir /app
WORKDIR app
EXPOSE 8060
ARG JAR_FILE=build/libs/flightService-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]