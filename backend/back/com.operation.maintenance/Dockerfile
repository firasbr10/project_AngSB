# Étape 1 : Construction du projet avec Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Exécution du JAR avec JDK
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Port exposé
EXPOSE 9092

# Commande de lancement
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]

