package com.datatower.patientsInsight.controller;

import com.datatower.patientsInsight.dto.Gender;
import com.datatower.patientsInsight.dto.PatientCreateResponse;
import com.datatower.patientsInsight.dto.PatientDto;
import com.datatower.patientsInsight.model.Patient;
import com.datatower.patientsInsight.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Operation(summary = "Create the patient data.",
            description = "This API implementation will return a newly created patient information.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "Patients request accepted, returns newly created patient id"),
            @ApiResponse(responseCode = "400",
                    description = "Invalid request, for example invalid gender provided, etc"),
            @ApiResponse(responseCode = "500",
                    description = "Patient service encountered an unexpected internal error"),
            @ApiResponse(responseCode = "503",
                    description = "Patient service encountered a temporary internal error")})
    @PostMapping
    public ResponseEntity<PatientCreateResponse> createPatientData(@NotNull @Valid @RequestBody PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        return new ResponseEntity<>(
                new PatientCreateResponse(
                        patientService.createPatient(patient)
                ),
                HttpStatus.CREATED
        );
    }

    @Operation(summary = "Get the patient data using the id.",
            description = "This API implementation will return the existing patient information.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "returns existing patient data"),
            @ApiResponse(responseCode = "400",
                    description = "Invalid request, for example invalid patientId provided, etc"),
            @ApiResponse(responseCode = "500",
                    description = "Patient service encountered an unexpected internal error"),
            @ApiResponse(responseCode = "503",
                    description = "Patient service encountered a temporary internal error")})
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDto> getPatientData(@NotNull @PathVariable UUID patientId) {
        return new ResponseEntity<>(
                modelMapper.map(patientService.getPatient(patientId), PatientDto.class),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Get the list of patient data using the gender.",
            description = "This API implementation will return all the patient information based on given gender information.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",
            description = "returns all existing patients data or gender as filter"),
            @ApiResponse(responseCode = "400",
                    description = "Invalid request, for example invalid gender information provided."),
            @ApiResponse(responseCode = "500",
                    description = "Patient service encountered an unexpected internal error"),
            @ApiResponse(responseCode = "503",
                    description = "Patient service encountered a temporary internal error")})
    @GetMapping
    public ResponseEntity<?> getPatientDataByGender(@RequestParam Gender gender) {
        List<Patient> patients = patientService.getAllPatient(gender);
        return new ResponseEntity<>(
                patients.stream()
                        .map(patient -> modelMapper.map(
                                patient, PatientDto.class)
                        )
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
}
