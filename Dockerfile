# Usamos una imagen de Maven con Java 21
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usamos una imagen ligera de JDK 21 para ejecutar la API
FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 3003
ENTRYPOINT ["java", "-jar", "app.jar"]
