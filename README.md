# PatientInsight
Manage Patient Details

Requirement :

Develop an application that manages patient data as described below.
Model
The application handles patient data - a patient is described by the following attributes:
- First name
- Last name
- Gender
- Birthday
  Operations
  The application should support all of the operations listed below and expose them via a
  RESTful API.
- List all female patients
- Show details of a specific patient
- Create a new patient
- Delete an existing patient
  Requirements
  The operations listed above should implement the following rules.
- The application only allows patients who are older than 18 years.
- Patient data should be stored persistently.
- Collections should be sorted by last name ascending.

Technology Stack :
- Java 11
- Spring Boot
- Spring Data
- Lombok
- H2 Database

How to access the API's using Swagger UI ?
http://localhost:8080/swagger or
http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config

How to run the "Patient Manager Application" ?
 - mvn spring-boot:run

How to access the H2 database ?
 - http://localhost:8080/h2-console
 - Table Name - Patients
 - Database name - patientsinsight

Technical Decisions :

Further Improvements / Technical Debt :

