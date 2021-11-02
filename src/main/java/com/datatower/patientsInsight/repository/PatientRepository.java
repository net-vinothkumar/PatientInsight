package com.datatower.patientsInsight.repository;

import com.datatower.patientsInsight.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {
}
