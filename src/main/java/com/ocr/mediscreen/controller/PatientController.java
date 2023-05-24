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

    //Récupérer la liste des patients
    @RequestMapping(value = "/Patients", method = RequestMethod.GET)

    public String listePatients() {

        List<Patient> patientList = patientService.findAll();

        return patientList.toString();
    }

    //Récupérer un patient par son Id
    @GetMapping(value = "/Patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable int id) {
        return patientService.findById(id);

    }

    @GetMapping(value = "/Patients/{firstname}")
    public Optional<Patient> getPatientByFirstname(@PathVariable String firstname) {
        return patientService.findByFirstname(firstname);

    }

}
