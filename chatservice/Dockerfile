# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set working directory for the build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .

# Download Maven dependencies (these will be cached if unchanged)
RUN mvn dependency:go-offline

# Copy the entire project
COPY src ./src

# Package the application as a JAR file
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR from the first stage
COPY --from=build /app/target/chatservice-0.0.1-SNAPSHOT.jar /chatservice.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/chatservice.jar"]
