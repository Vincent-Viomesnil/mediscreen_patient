package com.ocr.mediscreen.service;

import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.repository.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
}
