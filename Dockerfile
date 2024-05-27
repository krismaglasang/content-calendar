# Use Maven and OpenJDK for the build stage
FROM openjdk:17-jdk-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Create a user and group to run the application (instead of using root)
RUN groupadd -r app && useradd -r -g app app

# Build the project, skipping tests
RUN mvn clean package -DskipTests

# Use Corretto for the runtime stage
FROM amazoncorretto:17-alpine-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /app/target/*.jar ./app.jar

# Create a user and group to run the application (instead of using root)
RUN addgroup -S app && adduser -S -G app -s /bin/sh app

# Expose port 8080 to the outside world
EXPOSE 8080

# Switch to the non-root user created earlier
USER app

# Command to run the application
CMD ["java", "-jar", "app.jar"]
