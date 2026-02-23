# API Consulta de RUC - Spring Boot

Backend en **Spring Boot** para consultar información de empresas mediante RUC usando la API **DECOLECTA**.  
Spring Boot + JPA crea automáticamente las tablas `company` y `consulta` según las entidades definidas.

#Tecnologías utilizadas

- **Java 17**  
- **Spring Boot**  
- **Spring Data JPA / Hibernate**  
- **PostgreSQL**  
- **Maven**

Configuración

###  application.properties

Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bdjava14
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update

#Token para DECOLECTA API
decolecta.token=${DECOLECTA_TOKEN}
Token DECOLECTA

CONFIGURAR TOKEN DECOLECTA

El proyecto necesita un token para autenticarse con la API externa. No lo pongas directamente en el código.

Opciones para configurarlo

1.Usando IntelliJ (recomendado para desarrollo):

  -Ve a Run → Edit Configurations…
  -Selecciona tu configuración de ejecución del proyecto
  -En Environment variables, agrega:
      DECOLECTA_TOKEN=TU_TOKEN_AQUI

Guarda y ejecuta el proyecto. Spring Boot reemplazará automáticamente ${DECOLECTA_TOKEN} en application.properties.

2. Usando variables de entorno del sistema:

    Windows (PowerShell):
    -setx DECOLECTA_TOKEN "TU_TOKEN_AQUI"
    
    Linux / Mac:
    -export DECOLECTA_TOKEN=TU_TOKEN_AQUI
    
    Luego reinicia tu IDE o terminal antes de correr el proyecto.

COMO CORRER EL PROYECTO

Clonar el repositorio:

  git clone <URL_DEL_REPOSITORIO>
  cd <NOMBRE_DEL_PROYECTO>

Construir y ejecutar con Maven:

  mvn clean install
  mvn spring-boot:run

El proyecto correrá por defecto en: http://localhost:8080

Endpoints disponibles
1. Consultar RUC
GET /api/ruc/{ruc}

  Ejemplo:
  
  GET /api/ruc/20601030013
  
  RUC válido → se guarda en company y consulta
  RUC inválido → solo se guarda en consulta

Ejemplo de respuesta:
  
  {
    "ruc": "20601030013",
    "razonSocial": "EMPRESA EJEMPLO SAC",
    "direccion": "LIMA"
  }
2. Listar todas las consultas
  GET /api/consultas
  
  Devuelve todos los registros de la tabla consulta con información de:

  -RUC consultado
  -Resultado (SUCCESS / ERROR)
  -Código de estado del proveedor
  -Fecha y hora de la consulta

Autor

Paulo Olivera
Proyecto académico - Integración con API externa
