package com.ocr.mediscreen.service;

import com.ocr.mediscreen.exceptions.PatientNonCreeException;
import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.repository.PatientDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    public List<Patient> findAll() {
        return patientDAO.findAll();
    }


    public Optional<Patient> findById(Integer id) {
        return patientDAO.findById(id);
    }

    public Optional<Patient> findByFirstname(String firstname) {
        return patientDAO.findByFirstname(firstname);
    }

    public Patient addPatient(Patient patient) {
        return patientDAO.save(patient);
    }

    public Patient updatePatient(String firstname, Patient patientToUpdate) {
        Optional<Patient> patient = patientDAO.findByFirstname(firstname);
        log.info("Patient " + patient);
        patientDAO.save(patientToUpdate);
        return patientToUpdate;

    }

    public Patient deletePatient(String firstname) {
        Optional<Patient> patient = patientDAO.findByFirstname(firstname);
        patient.ifPresent(value -> patientDAO.delete(value));
        return null;
    }
}