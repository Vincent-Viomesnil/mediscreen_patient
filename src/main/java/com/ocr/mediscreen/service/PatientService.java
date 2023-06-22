package com.ocr.mediscreen.service;

import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.repository.PatientDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Optional<Patient> findById(Long id) {
        return patientDAO.findById(id);
    }

    public Optional<Patient> findByLastname(String lastname) {
        return patientDAO.findByLastname(lastname);
    }

    public Patient addPatient(Patient patient) {
        return patientDAO.save(patient);
    }

    public Patient updatePatientByLastname(String lastname, Patient patientToUpdate) {
        Optional<Patient> patient = patientDAO.findByLastname(lastname);
        log.info("Patient " + patient);
        patientDAO.save(patientToUpdate);
        return patientToUpdate;

    }

    public Patient updatePatientById(Long id, Patient patientToUpdate) {
        Optional<Patient> patient = patientDAO.findById(id);
        log.info("Patient " + patient);
        patientDAO.save(patientToUpdate);
        return patientToUpdate;

    }

    public Patient deletePatientByLastname(String lastname) {
        Optional<Patient> patient = patientDAO.findByLastname(lastname);
        patient.ifPresent(value -> patientDAO.delete(value));
        return null;
    }

    public Patient deletePatientById(Long id) {
        Optional<Patient> patient = patientDAO.findById(id);
        patient.ifPresent(value -> patientDAO.delete(value));
        return null;
    }
}