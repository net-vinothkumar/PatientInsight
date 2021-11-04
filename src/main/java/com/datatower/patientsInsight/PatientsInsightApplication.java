package com.datatower.patientsInsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PatientsInsightApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsInsightApplication.class, args);
	}

}
