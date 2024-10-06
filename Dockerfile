# Usamos una imagen de Maven con Java 21
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usamos una imagen ligera de JDK 21 para ejecutar la API
FROM openjdk:21-jdk-slim
WORKDIR /app

# Instalar netcat-openbsd en la imagen slim
RUN apt-get update && apt-get install -y netcat-openbsd

COPY --from=build /app/target/*.jar app.jar
COPY wait-for-it.sh ./
RUN chmod +x wait-for-it.sh
EXPOSE 3003
ENTRYPOINT ["./wait-for-it.sh", "db", "3306", "--", "java", "-jar", "app.jar"]
