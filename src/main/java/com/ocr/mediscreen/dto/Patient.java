//package com.ocr.mediscreen.dto;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDate;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Patient {
//
//    private Long id;
//    private String firstname;
//    private String lastname;
//    private LocalDate birthdate;
//    private String gender;
//    private String address;
//    private String phonenumber;
//
//
//    public Patient(String firstname,
//                   String lastname,
//                   LocalDate birthdate,
//                   String gender,
//                   String address,
//                   String phonenumber) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.birthdate = birthdate;
//        this.gender = gender;
//        this.address = address;
//        this.phonenumber = phonenumber;
//    }
//
//    public Patient(com.ocr.mediscreen.model.Patient patient) {
//        this.id = patient.getId();
//        this.firstname = patient.getFirstname();
//        this.lastname = patient.getLastname();
//        this.birthdate = patient.getBirthdate();
//        this.gender = patient.getGender();
//        this.address = patient.getAddress();
//        this.phonenumber = patient.getPhonenumber();
//    }
//}
