FROM openjdk:18-jdk-alpine
RUN mkdir /app
WORKDIR app
EXPOSE 8050
ARG JAR_FILE=build/libs/bonusService-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]