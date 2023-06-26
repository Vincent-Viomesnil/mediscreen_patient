package com.ocr.mediscreen.dto;


import com.ocr.mediscreen.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String gender;
    private String address;
    private String phonenumber;


    public PatientDto(String firstname,
                      String lastname,
                      LocalDate birthdate,
                      String gender,
                      String address,
                      String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public PatientDto(Patient patient) {
        this.id = patient.getId();
        this.firstname = patient.getFirstname();
        this.lastname = patient.getLastname();
        this.birthdate = patient.getBirthdate();
        this.gender = patient.getGender();
        this.address = patient.getAddress();
        this.phonenumber = patient.getPhonenumber();
    }
}
