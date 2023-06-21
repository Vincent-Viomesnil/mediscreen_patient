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
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        Patient patientAdded = patientService.addPatient(patient);
        if (patientAdded != null) {
            return ResponseEntity.ok(patientAdded).getBody();
        }
        throw new PatientNonCreeException("Verify the mandatory data");
    }


    @RequestMapping(value = "Patient/update", method = RequestMethod.PUT)
    public Patient updatePatientByLastname(@RequestParam("lastname") String lastname, @RequestBody Patient patientToUpdate) {
        return patientService.updatePatientByLastname(lastname, patientToUpdate);
    }

    @PutMapping(value = "/Patient/update/{id}")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patientToUpdate) {
        return patientService.updatePatientById(id, patientToUpdate);
    }


    @RequestMapping(value="Patient/delete", method = RequestMethod.DELETE)
    public Patient deletePatientByLastname(@RequestParam("lastname") String lastname) {
        return patientService.deletePatientByLastname(lastname);
    }

    @DeleteMapping(value="/Patient/delete/{id}")
    public Patient deletePatientById(@PathVariable Long id) {
        return patientService.deletePatientById(id);
    }

}
