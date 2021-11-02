package com.datatower.patientsInsight.service;

import com.datatower.patientsInsight.model.Patient;
import com.datatower.patientsInsight.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public String createPatient(Patient patient) {
        Patient newPatient = patientRepository.save(patient);
        return newPatient.getId().toString();
    }
}
