package com.datatower.patientsInsight.model;

import com.datatower.patientsInsight.dto.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "patients")
@Entity
public class Patient {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Column(name = "id")
    private UUID id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column
    private LocalDate birthDate;

    private LocalDate createdAt = LocalDate.now();
}
