package com.datatower.patientsInsight.repository;

import com.datatower.patientsInsight.dto.Gender;
import com.datatower.patientsInsight.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends CrudRepository<Patient, UUID> {
    List<Patient> findAll();

    List<Patient> findByGender(Gender gender);
}
