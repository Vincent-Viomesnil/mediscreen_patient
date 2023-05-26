package com.ocr.mediscreen.controller;

import com.ocr.mediscreen.excepetions.PatientIntrouvableException;
import com.ocr.mediscreen.excepetions.PatientNonCreeException;
import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;
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
//    @GetMapping(value = "/Patient/{firstname}")
//    public Optional<Patient> getPatientByFirstname(@PathVariable String firstname) {
//        Optional<Patient> patient = patientService.findByFirstname(firstname);
//        if (patient.isEmpty()) throw new PatientIntrouvableException("Patient with firstname: " + firstname + " is not found");
//        return patient;
//    }
//    @PostMapping(value ="/Patient/add" )
//    public Patient postPatient(@RequestBody Patient patient) {
//        return patientService.addPatient(patient);
//    }

    @GetMapping(value = "/Patient/{firstname}")
    public ResponseEntity<?> getPatientByFirstname(@Valid @PathVariable String firstname) {
        Optional<Patient> patient = patientService.findByFirstname(firstname);
        if (patient.isEmpty()) {
            throw new PatientIntrouvableException("Patient with firstname: " + firstname + " is not found");
        } else {
            return ResponseEntity.ok(patient.get());
        }
    }

   @PostMapping(value = "/Patient/add")
    public ResponseEntity<?> addPatient(@Valid @RequestBody Patient patient) {
        Patient patientAdded = patientService.addPatient(patient);
        if (patientAdded.getFirstname()==null
                /*||patientAdded.getId()==null
                || patientAdded.getLastname()==null||patientAdded.getGender()==null||
                patientAdded.getBirthdate()==null*/)  {
            throw new PatientNonCreeException("Patient non created, please verify mandatory data" +patientAdded);
        } else {
            return ResponseEntity.ok(patientAdded);
        }
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
