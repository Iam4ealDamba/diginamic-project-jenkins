# Build stage
FROM maven:3.9.9-amazoncorretto-17 as build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean package

# Run stage
FROM openjdk:17-alpine 
WORKDIR /app
COPY --from=build /app/target/projet-jenkins-1.0-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "projet-jenkins-1.0-SNAPSHOT.jar"]