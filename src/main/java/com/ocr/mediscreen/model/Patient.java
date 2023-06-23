package com.ocr.mediscreen.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @GeneratedValue
    @NotNull
    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private LocalDate birthdate;
    @NotNull
    private String gender;

    private String address;
    private String phonenumber;

}

