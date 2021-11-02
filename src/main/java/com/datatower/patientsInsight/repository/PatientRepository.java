package com.datatower.patientsInsight.repository;

import com.datatower.patientsInsight.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PatientRepository extends CrudRepository<Patient, UUID> {
}
