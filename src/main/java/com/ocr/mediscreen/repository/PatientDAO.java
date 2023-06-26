package com.ocr.mediscreen.repository;

import com.ocr.mediscreen.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientDAO extends JpaRepository<Patient, Long> {


}
