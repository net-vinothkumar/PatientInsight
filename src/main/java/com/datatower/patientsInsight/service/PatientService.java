package com.datatower.patientsInsight.service;

import com.datatower.patientsInsight.dto.Gender;
import com.datatower.patientsInsight.exception.ResourceNotFoundException;
import com.datatower.patientsInsight.model.Patient;
import com.datatower.patientsInsight.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public String createPatient(Patient patient) {
        Patient newPatient = patientRepository.save(patient);
        return newPatient.getId().toString();
    }

    public Patient getPatient(UUID patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Patient with id %s not found",
                                patientId)
                ));
    }

    public List<Patient> getAllPatient(Gender gender) {
        if (gender == null) {
            /** by default female patients - this could be improved
             * if the user provides gender MALE / FEMALE we return the patients
             * else we shall return all the patients.
             **/
            return patientRepository.findByGenderOrderByLastNameAsc(Gender.FEMALE);
        } else {
            return patientRepository.findByGenderOrderByLastNameAsc(gender);
        }
    }

    public void deletePatient(UUID patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            patientRepository.deleteById(patientId);
        } else {
            throw new ResourceNotFoundException(
                    String.format("Patient with id %s not exist",
                            patientId)
            );
        }
    }
}
