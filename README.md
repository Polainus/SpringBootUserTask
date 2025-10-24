# SpringBootUserTask
Api simple para demostración 

## 📘 Descripción

API REST desarrollada con **Spring Boot** y base de datos **H2** para la gestión de **usuarios** y sus **tareas**, con soporte para **Docker**.
Incluye endpoints CRUD, autenticación básica de usuarios y persistencia en memoria para desarrollo.

## 🧱 Tecnologías

* Java 17
* Spring Boot
* H2 Database
* Docker / Docker Compose
* Maven

## 🚀 Ejecución rápida

mvn clean package
docker build -t api-gestion-usuarios .
docker run -d -p 8080:8080 api-gestion-usuarios

* API: [http://localhost:8080/api/users](http://localhost:8080/api/users)
* Consola H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

