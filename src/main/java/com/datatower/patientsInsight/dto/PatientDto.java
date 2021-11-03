package com.datatower.patientsInsight.dto;

import com.datatower.patientsInsight.validator.Adult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PatientDto {

    @Schema(description = "Patient's first name.")
    @NotEmpty(message = "patient's first name cannot be null or empty.")
    private String firstName;

    @Schema(description = "Patient's last name.")
    @NotEmpty(message = "patient's last name cannot be null or empty.")
    private String lastName;

    @Schema(description = "Patient's gender.")
    @NotNull(message = "patient's gender cannot be null.")
    private Gender gender;

    @Schema(description = "Patient's date of birth.")
    @Adult
    private LocalDate birthDate;
}
