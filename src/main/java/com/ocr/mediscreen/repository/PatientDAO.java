package com.ocr.mediscreen.repository;

import com.ocr.mediscreen.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Long> {
    List<Patient> findAll();

    Optional<Patient> findById(Long id);

    Patient save(Patient patient);

    Optional<Patient> findByLastname(String lastname);

    void delete(Patient patient);

}
