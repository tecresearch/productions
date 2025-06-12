# Stage 1: Build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven wrapper and settings
COPY mvnw .
COPY .mvn .mvn

# Copy POM and download dependencies (better Docker cache usage)
COPY pom.xml .

RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port for Render (Render uses port 8080 by default for web services)
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
