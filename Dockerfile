# Use the official Maven image based on Alpine as the parent image
FROM maven:3.3-jdk-8 AS build

# Set the working directory in the container
#WORKDIR /app

# Copy the current directory contents into the container at /app
COPY src /home/app/src
COPY pom.xml /home/app

# Install any necessary dependencies and build the application
RUN mvn -f /home/app/pom.xml clean package

# Use the official OpenJDK image based on Alpine
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
#WORKDIR /app

# Copy the built jar file from the Maven container
COPY --from=build /home/app/target/myopenshiftdemo-0.0.1-SNAPSHOT.jar  /usr/local/lib/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
