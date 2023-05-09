# Usa una imagen base de OpenJDK 11
FROM openjdk:17-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado por Spring Boot en el directorio de trabajo
COPY build/libs/ejemplogitano-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecuta la aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]
