package com.ocr.mediscreen.service;

import com.ocr.mediscreen.dto.PatientDto;
import com.ocr.mediscreen.exceptions.PatientNotFoundException;
import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.repository.PatientDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    public List<PatientDto> findAll()  {
        List<Patient> patientList = patientDAO.findAll();
        return patientList.stream()
                .map(patient -> new PatientDto(patient))
                .collect(Collectors.toList());
    }


    public PatientDto findById(Long id) {
        Optional<Patient> patient = patientDAO.findById(id);
        if (!patient.isPresent()) throw new PatientNotFoundException("Patient with id " + id + " doesn't exist");
        return new PatientDto(patient.get());
    }


    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = new Patient(patientDto);
        return new PatientDto(patientDAO.save(patient));
    }



    public PatientDto updatePatientById(Long id, PatientDto patientDto) {
        if (patientDAO.findById(id).isPresent()) {
            Patient patient = new Patient(patientDto);
            patient.setId(id);
            return new PatientDto(patientDAO.save(patient));
        } else throw new PatientNotFoundException("The patient with id "+id + " doesn't exist");
    }


//    public Patient deletePatientById(Long id) {
//        Optional<Patient> patient = patientDAO.findById(id);
//        patient.ifPresent(value -> patientDAO.delete(value));
//        return null;
//    }
}