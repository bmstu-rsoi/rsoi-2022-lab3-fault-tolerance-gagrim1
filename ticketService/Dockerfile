FROM openjdk:18-jdk-alpine
RUN mkdir /app
WORKDIR app
EXPOSE 8070
ARG JAR_FILE=build/libs/ticketService-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]