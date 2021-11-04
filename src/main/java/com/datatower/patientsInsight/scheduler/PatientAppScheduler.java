package com.datatower.patientsInsight.scheduler;


import com.datatower.patientsInsight.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PatientAppScheduler {

    private final PatientRepository patientRepository;

    @Scheduled(cron = "0 0 0 * * *") // EVERY DAY AT 12:00 AM.
    public void deletePatientsOlderThanAYear() {
        System.out.println("deleting");
        LocalDate dateBeforeOneYear = LocalDate.now().minusYears(1);
        patientRepository.deleteByCreatedAtBefore(dateBeforeOneYear);
    }
}
