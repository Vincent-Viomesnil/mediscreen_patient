package com.ocr.mediscreen.controller;

import com.ocr.mediscreen.exceptions.PatientNotFoundException;
import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPatientList() {
        // Mocking the service response
        List<Patient> patients = new ArrayList<>();
        Date birthdate = new Date();
        patients.add(new Patient(1L, "firstname", "firstname", birthdate, "F", "address", "0102030405"));
        patients.add(new Patient(2L, "lastname", "lastname", birthdate, "F", "address", "1234567890"));
        when(patientService.findAll()).thenReturn(patients);

        // Calling the controller method
        List<Patient> result = patientController.patientList();

        // Verifying the service method was called
        verify(patientService, times(1)).findAll();

        // Asserting the result
        assertEquals(patients, result);
    }

    @Test
    void testGetPatientByLastname() {
        // Mocking the service response
        Date birthdate = new Date();
        Optional<Patient> patient = Optional.of(new Patient(1L, "firstname", "firstname", birthdate, "F", "address", "0102030405"));

        when(patientService.findByLastname("Doe")).thenReturn(patient);

        // Calling the controller method
        Optional<Patient> result = patientController.getPatientByLastname("Doe");

        // Verifying the service method was called
        verify(patientService, times(1)).findByLastname("Doe");

        // Asserting the result
        assertEquals(patient, result);
    }

    @Test
    void testGetPatientByLastnameNoPatient() {
        // Mocking the service response
        when(patientService.findByLastname("Lastname")).thenReturn(Optional.empty());

        // Calling the controller method
        assertThrows(PatientNotFoundException.class, () -> {
            patientController.getPatientByLastname("Lastname");
        });

        // Verifying the service method was called
        verify(patientService, times(1)).findByLastname("Lastname");
    }

    @Test
    void testGetPatientById() {
        // Mocking the service response
        Date birthdate = new Date();
        Optional<Patient> patient = Optional.of(new Patient(1L, "firstname", "firstname", birthdate, "F", "address", "0102030405"));
        when(patientService.findById(1L)).thenReturn(patient);

        // Calling the controller method
        Optional<Patient> result = patientController.getPatientById(1L);

        // Verifying the service method was called
        verify(patientService, times(1)).findById(1L);

        // Asserting the result
        assertEquals(patient, result);
    }

    @Test
    void testGetPatientByIdNonExistingPatient() {
        // Mocking the service response
        when(patientService.findById(1L)).thenReturn(Optional.empty());

        // Calling the controller method
        assertThrows(PatientNotFoundException.class, () -> {
            patientController.getPatientById(1L);
        });

        // Verifying the service method was called
        verify(patientService, times(1)).findById(1L);
    }
}

