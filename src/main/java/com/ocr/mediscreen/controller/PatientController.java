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

    public List<Patient> patientList() {

        List<Patient> patientList = patientService.findAll();

        return patientList;
    }

    //Retrieve patients'list by firstname
    @GetMapping(value = "/Patient/{firstname}")
    public Optional<Patient> getPatientByFirstname(@PathVariable String firstname) {
        return patientService.findByFirstname(firstname);
    }

}
