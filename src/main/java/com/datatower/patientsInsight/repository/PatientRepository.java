package com.datatower.patientsInsight.repository;

import com.datatower.patientsInsight.dto.Gender;
import com.datatower.patientsInsight.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    List<Patient> findAll();

    List<Patient> findByGenderOrderByLastNameAsc(Gender gender);

    @Modifying
    @Transactional
    void deleteByCreatedAtBefore(LocalDate dateBeforeOneYear);
}
