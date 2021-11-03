package com.datatower.patientsInsight.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private String errorMessage;
}
