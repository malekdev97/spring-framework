FROM openjdk:19-jdk-alpine
RUN addgroup -S app && adduser -S app -G app
USER app

# Copy the JAR file
COPY target/backend-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080:8080

# Set the entry point
ENTRYPOINT ["java", "-jar", "/app/backend-0.0.1-SNAPSHOT.jar"]