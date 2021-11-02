DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
  id BINARY(16) NOT NULL primary key,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  gender VARCHAR(10) NOT NULL,
  birthDate DATE NOT NULL
);
