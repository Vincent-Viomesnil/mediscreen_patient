package com.ocr.mediscreen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private String gender;
    private String address;
    private String phoneNumber;

}

