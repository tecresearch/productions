# ------------ Stage 1: Build the application ------------
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Copy Maven configuration and source files
COPY pom.xml .
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# ------------ Stage 2: Run the application ------------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the packaged jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Let Render dynamically assign the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
