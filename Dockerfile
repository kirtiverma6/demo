# Use a base image with Maven and Java
FROM maven:3.8.3-openjdk-11-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Build the project dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the Maven project
RUN mvn package

# Use a lighter base image for the runtime
FROM openjdk:11-slim

# Set the working directory
WORKDIR /app

# Copy the .jar file to the working directory
COPY target/kirti-demo.jar .

# Expose port 8080
EXPOSE 8082

# Set the entry point to run the web app
CMD ["java", "-jar", "kirti-demo.jar"]