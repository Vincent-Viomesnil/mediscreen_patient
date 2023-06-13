package com.ocr.mediscreen.controller;

import com.ocr.mediscreen.exceptions.PatientIntrouvableException;
import com.ocr.mediscreen.exceptions.PatientNonCreeException;
import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping(value = "/Patient/lastname/{lastname}")
    public Optional<Patient> getPatientByLastname(@Valid @PathVariable String lastname) {
        Optional<Patient> patient = patientService.findByLastname(lastname);
        if (patient.isEmpty()) {
            throw new PatientIntrouvableException("Patient with lastname: " + lastname + " is not found");
        }
        return patient;
    }

    @GetMapping(value = "/Patient/id/{id}")
    public Optional<Patient> getPatientById(@Valid @PathVariable Long id) {
        Optional<Patient> patient = patientService.findById(id);
        if (patient.isEmpty()) {
            throw new PatientIntrouvableException("Patient with id: " + id + " is not found");
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


    @PutMapping(value = "/Patient/update/{lastname}")
    public Patient updatePatient(@PathVariable String lastname, @RequestBody Patient patientToUpdate) {
        return patientService.updatePatient(lastname, patientToUpdate);
    }

    @DeleteMapping(value="/Patient/delete/{lastname}")
    public Patient deletePatient(@PathVariable String lastname) {
        return patientService.deletePatient(lastname);
    }

}
