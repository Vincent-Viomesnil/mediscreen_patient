package com.ocr.mediscreen.controller;

import com.ocr.mediscreen.dto.PatientDto;
import com.ocr.mediscreen.exceptions.PatientNotFoundException;
import com.ocr.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;


    @RequestMapping(value = "/Patients", method = RequestMethod.GET)
    public List<PatientDto> patientList() {
        return patientService.findAll();
    }


    @GetMapping("/Patient/id/{id}")
    public PatientDto getPatientById(@PathVariable Long id) throws PatientNotFoundException {
        return patientService.findById(id);
    }



    @PostMapping("/Patient/add")
    public PatientDto addPatient(@RequestBody PatientDto patientDto) throws Exception {
        return patientService.addPatient(patientDto);
    }
//    @PostMapping("/Patient/add")
//    public PatientDto addPatient(@RequestBody Patient patient) throws Exception {
//        return patientService.addPatient(patient);
//    }

    @PutMapping("/Patient/update/{id}")
    public PatientDto updatePatientById(@PathVariable("id") Long id, @RequestBody PatientDto patient) {
        return patientService.updatePatientById(id, patient);
    }


    @DeleteMapping(value="/Patient/delete/{id}")
    public void deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
    }

}
