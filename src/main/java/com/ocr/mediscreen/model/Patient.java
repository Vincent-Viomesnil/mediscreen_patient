package com.ocr.mediscreen.model;


import com.ocr.mediscreen.dto.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @NotNull
    private String gender;

    private String address;
    private String phonenumber;

    //public class Patient extends PatientDto { + constructeur différent
    public Patient(PatientDto patientDto) {
        this.firstname = patientDto.getFirstname();
        this.lastname = patientDto.getLastname();
        this.birthdate = patientDto.getBirthdate();
        this.gender = patientDto.getGender();
        this.address = patientDto.getAddress();
        this.phonenumber = patientDto.getPhonenumber();
    }
}

