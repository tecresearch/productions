# Stage 1: Build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the Maven wrapper (if you use mvnw)
COPY mvnw .
COPY .mvn .mvn

# Copy only pom.xml and download dependencies first (for Docker cache efficiency)
COPY pom.xml .

RUN ./mvnw dependency:go-offline

# Copy the entire project source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
