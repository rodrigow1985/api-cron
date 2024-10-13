#FROM openjdk:17-jdk-alpine
#COPY target/dockerized.postgresql-0.0.1-SNAPSHOT.jar java-app.jar
#ENTRYPOINT ["java", "-jar", "java-app.jar"]
# Utilizar una imagen de Maven con JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .

# Descargar dependencias sin construir el proyecto aún
RUN mvn dependency:go-offline -B

# Copiar el código fuente del proyecto
COPY src ./src

# Compilar y empaquetar la aplicación (esto ejecuta clean package)
RUN mvn clean package -DskipTests

# Segunda etapa: usar una imagen más ligera para el runtime
FROM eclipse-temurin:17-jdk-alpine

# Crear un directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo JAR generado desde la etapa de compilación
COPY --from=build /app/target/*.jar java-app.jar

# Exponer el puerto en el que corre Spring Boot
#EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "java-app.jar"]