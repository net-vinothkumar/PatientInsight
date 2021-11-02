package com.datatower.patientsInsight.controller;

import com.datatower.patientsInsight.dto.Gender;
import com.datatower.patientsInsight.model.Patient;
import com.datatower.patientsInsight.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @MockBean
    private PatientService patientService;

    @Autowired
    private MockMvc mockMvc;

    private final static String SAMPLE_REQUEST = "{\n" +
            "  \"firstName\": \"Test Patient First Name\",\n" +
            "  \"lastName\": \"Test Last Name\",\n" +
            "  \"gender\" : \"MALE\",\n" +
            "  \"birthDate\": \"2021-11-02\"\n" +
            "}";
    private static final String API_BASE_PATH_V1 = "/api/v1/patients";

    @Test
    void shouldBeAbleToCreatePatientData() throws Exception {
        String patientId = UUID.randomUUID().toString();

        when(patientService.createPatient(any())).thenReturn(patientId);

        mockMvc.perform(MockMvcRequestBuilders
                .post(API_BASE_PATH_V1)
                .content(SAMPLE_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(String.format("{\"patientId\":\"%s\"}", patientId)));
    }

    @Test
    void shouldBeAbleToGetThePatientDataUsingPatientId() throws Exception {
        Patient patient = new Patient();
        patient.setFirstName("Test First Name");
        patient.setLastName("Test Last Name");
        patient.setGender(Gender.MALE);
        patient.setBirthDate(LocalDate.now());

        UUID patientId = UUID.randomUUID();

        when(patientService.getPatient(patientId)).thenReturn(patient);

        mockMvc.perform(get(API_BASE_PATH_V1 + "/" + patientId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(
                        "{\"firstName\":\"Test First Name\"," +
                                "\"lastName\":\"Test Last Name\"," +
                                "\"gender\":\"MALE\"," +
                                "\"birthDate\":\"2021-11-02\"}")
                );
    }
}
