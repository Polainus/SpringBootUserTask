# Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiamos el jar ya generado
COPY app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
