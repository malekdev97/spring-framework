# Description: Dockerfile for OpenJDK 17
FROM openjdk:17
# VOLUME stores the data in the host machine
VOLUME /tmp
# EXPOSE the port 8080
EXPOSE 8080
# COPY the jar file to the container
COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar
# ENTRYPOINT to run the jar file
ENTRYPOINT ["java", "-jar", "/backend.jar"]
