![LiterAlura Banner](https://your-image-link.com/banner.png)

# Literatura - Catálogo de Libros 📚

**Desafío del curso de programación backend con Java de Alura y Oracle**

---

## Descripción

**Literatura** es una aplicación de consola desarrollada en **Java** que permite a los usuarios interactuar con un catálogo de libros. A través de esta aplicación, los usuarios pueden buscar libros por título, listar libros y autores registrados, y gestionar información literaria.  
El proyecto pone en práctica conceptos clave como:
- **Funciones Lambda** y **Streams**
- **Consumo de APIs**
- **Persistencia de datos** y conexión a bases de datos
- **Arquitectura de capas** con **Spring Boot** y **PostgreSQL**

---

## Tecnologías Utilizadas 🛠️

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

---

## Funcionalidades

- **Buscar libro por título:** Permite al usuario buscar libros ingresando el título deseado.
- **Listar libros registrados:** Muestra una lista de todos los libros almacenados en la base de datos.
- **Listar autores registrados:** Muestra una lista de todos los autores almacenados en la base de datos.
- **Listar autores vivos en un determinado año:** Muestra una lista de autores vivos durante un año específico.
- **Listar libros por idioma:** Filtra los libros según el idioma deseado.
- **Persistencia de datos:** Almacena libros y autores en una base de datos PostgreSQL para su gestión y consulta.
- **Consumo de API externa:** Solicita datos a la API de Gutendex y los convierte en objetos Java.

---

## Menú Interactivo

Al iniciar la aplicación, se mostrará un menú con las siguientes opciones:

```plaintext
-------------------------------------------------
Elija la Opción deseada:
1.- Buscar libro por título
2.- Listar libros registrados
3.- Listar autores registrados
4.- Listar autores vivos en un determinado año
5.- Listar libros por idioma

0.- Salir
-------------------------------------------------
```
El usuario puede ingresar el número de la opción deseada y seguir las instrucciones proporcionadas por la aplicación.

---

## Arquitectura del Proyecto 🏗️

El proyecto sigue una arquitectura de capas bien definida:

- **Controller**: Maneja las solicitudes del usuario y las respuestas de la aplicación.
- **Service**: Contiene la lógica de negocio y se encarga de la comunicación con APIs externas.
- **Repository**: Gestiona la interacción con la base de datos PostgreSQL.
- **Model**: Define las entidades y modelos de datos utilizados en la aplicación.
- **DTO (Data Transfer Object)**: Objetos utilizados para transferir datos entre las capas de la aplicación.
- **Mapper**: Mapea entre modelos y DTOs.
- **Config**: Contiene configuraciones adicionales, como la configuración del cliente HTTP para consumir la API externa.

---

## Aprendizajes y Habilidades Desarrolladas 🎓

Durante el desarrollo de este proyecto se adquirieron y reforzaron habilidades esenciales, como:

- **Consumo de APIs Externas**
  - Uso de HttpClient para realizar solicitudes HTTP.
  - Manipulación de respuestas JSON con Jackson (ObjectMapper).

- **Persistencia de Datos**
  - Uso de JPA e Hibernate para gestionar la persistencia en PostgreSQL.
  - Diseño de relaciones entre tablas, como uno-a-muchos.

- **Arquitectura de Capas**
  - Separación de responsabilidades entre controladores, servicios y repositorios.
  - Uso de DTOs y Mappers para transferir datos.

- **Java Avanzado**
  - Uso de funciones lambda y streams para procesar datos.
  - Manejo de excepciones personalizadas y validaciones.

- **Buenas Prácticas de Desarrollo**
  - Modularización y reutilización de código.
  - Implementación de un menú interactivo claro.
  - Documentación profesional del proyecto.

---

## Requisitos Previos ⚙️

- **Java 11** o superior
- **Maven 3.6** o superior
- **PostgreSQL 12** o superior

---

## Instalación y Ejecución 🚀

### Clonar el Repositorio

```sh
git clone https://github.com/nestorsauceda/literatura-api.git
cd literatura-api
```
## Configurar la Base de Datos
1. Crear una base de datos PostgreSQL llamada literatura_db.
2. Configurar las credenciales en el archivo application.properties:
```shields
spring.datasource.url=jdbc:postgresql://localhost:5432/literatura_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
## Compilar el Proyecto
```
mvn clean install
```
## Ejecutar la Aplicación
```
mvn spring-boot:run
```

##
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.






## Autor

Desarrollado por Nestor Sauceda.

**Contacto:**

* GitHub: https://github.com/nestorsauceda

* Email: nasp41@gmail.com

##

¡Gracias por revisar este proyecto! 😊
