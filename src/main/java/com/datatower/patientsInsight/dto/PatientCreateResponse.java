package com.datatower.patientsInsight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PatientCreateResponse {
    private String patientId;
}
