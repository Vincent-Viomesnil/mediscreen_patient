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
    @PostMapping(value ="/Patient/add" )
    public Patient postPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping(value ="/Patient/update/{firstname}" )
    public Patient updatePatient(@PathVariable String firstname, @RequestBody Patient patientToUpdate) {
        return patientService.updatePatient(firstname, patientToUpdate);
    }

    @DeleteMapping(value="/Patient/delete/{firstname}")
    public Patient deletePatient(@PathVariable String firstname) {
        return patientService.deletePatient(firstname);
    }

}
