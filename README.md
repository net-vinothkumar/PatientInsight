# PatientInsight - Patient Manager Application
Manage Patient Details

### Requirement :

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

### Technology Stack :
- Java 11
- Spring Boot
- Spring Data
- Spring Scheduler
- Spring Validator
- Swagger Doc / Spring Doc Open API  
- Lombok
- H2 Database
- Maven Build Tool

### List of Patient Manager Application API's :
  
  - curl -X 'POST' \
    'http://localhost:8080/api/v1/patients' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
    "firstName": "John",
    "lastName": "Eugen",
    "gender": "MALE",
    "birthDate": "2021-11-02"
    }'
    
  - curl -X 'GET' \
    'http://localhost:8080/api/v1/patients/233026c0-3b31-4eb3-9c40-a762fa59b723' \
    -H 'accept: */*'
    
  - curl -X 'GET' \
    'http://localhost:8080/api/v1/patients?gender=MALE' \
    -H 'accept: */*'
    
  - curl -X 'DELETE' \
    'http://localhost:8080/api/v1/patients/554cd7c0-c861-4829-ba67-e7419b15c5bd' \
    -H 'accept: */*'  
    
### How to access the API's using Swagger UI ?
  - http://localhost:8080/swagger or
  - http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config

### How to run the "Patient Manager Application" ?
 - mvn spring-boot:run

### How to access the H2 database ?
 - http://localhost:8080/h2-console
 - Table Name - Patients
 - Database name - patientsinsight

### Further Improvements / Technical Debt :

    1. Its better to write the test case for getting the patients data with lastname sorted in ASC.
    2. More focus on FHIR compliant entity fields usage. i.e data type string, boolean, UUID, etc.
    3. Improve the design for patientId , currently its UUID, require a technical brain stroming session.
    4. Improvement for the GET API - to get all the female patients, not sure why the API should return
       only female patients, using a filter we shall improve this API MALE or FEMALE or any other filter criteria.
    5. More test cases could be written for convering the edge cases, ie what if the user provide an invalid date, gender, etc.
    6. Require to discuss and handle to avoid duplicate patients.
    7. Improvement in error messages shown to the API consumer, i.e more user friendly and with specific data i.e UUID etc.
    8. Exception handling could be improved by creating custom error messages with more specific attributes.
    9. Add more logging to trace the flow use cases.
    10. Add test case for cleanup scheduler.
    11. Add integration test case to test the different layer interaction i.e Controller, Service, Repository.
    12. Patient - deleting records older than 1 year - scheduler - currently its running for everyday once at 12:00 AM, it could
        changed according to the requirement of product owner, frequency could be changed.
    13. Currently using H2 as database, we shall discuss and finalize a relational / NoSQL database for production usage.

### Few Snapshots :
Database with patient details -

<img width="840" alt="Screenshot 2021-11-04 at 14 48 58" src="https://user-images.githubusercontent.com/30971809/140325431-cf4cf1fd-9c90-4f42-9138-aad5901341bd.png">

Patient Manager API - 

<img width="681" alt="Screenshot 2021-11-04 at 14 58 11" src="https://user-images.githubusercontent.com/30971809/140326956-05c61d66-5e2f-405e-b8ab-6f09e486497c.png">

