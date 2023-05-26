package com.ocr.mediscreen.controller;

import com.ocr.mediscreen.exceptions.PatientIntrouvableException;
import com.ocr.mediscreen.exceptions.PatientNonCreeException;
import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping(value = "/Patient/{firstname}")
    public Optional<Patient> getPatientByFirstname(@Valid @PathVariable String firstname) {
        Optional<Patient> patient = patientService.findByFirstname(firstname);
        if (patient.isEmpty()) {
            throw new PatientIntrouvableException("Patient with firstname: " + firstname + " is not found");
        }
        return patient;
    }
    @PostMapping(value = "/Patient/add")
    public ResponseEntity<Object> addPatient(@Valid @RequestBody Patient patient) {
        Patient patientAdded = patientService.addPatient(patient);
        if (patientAdded != null) {
            return ResponseEntity.ok(patientAdded);
        }
        throw new PatientNonCreeException("Verify the mandatory data");
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
