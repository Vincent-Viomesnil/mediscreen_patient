package com.ocr.mediscreen.controller;

import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    //Retrieve patients'list
    @RequestMapping(value = "/Patients", method = RequestMethod.GET)

    public String listePatients() {

        List<Patient> patientList = patientService.findAll();

        return patientList.toString();
    }

    //Retrieve patients'list by id
    @GetMapping(value = "/Patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable int id) {
        return patientService.findById(id);

    }
    //Retrieve patients'list by firstname
    @GetMapping(value = "/Patients/{firstname}")
    public Optional<Patient> getPatientByFirstname(@PathVariable String firstname) {
        return patientService.findByFirstname(firstname);

    }

}
