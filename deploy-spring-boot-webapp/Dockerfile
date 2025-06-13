# Use OpenJDK 21 as base image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/app.jar app.jar

# Expose port (change if your app uses another port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
