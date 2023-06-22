package com.ocr.mediscreen.service;

import com.ocr.mediscreen.model.Patient;
import com.ocr.mediscreen.repository.PatientDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientDAO patientDAO;

    @InjectMocks
    private PatientService patientService;

    private List<Patient> patientList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        patientList = new ArrayList<>();
        patientList.add(new Patient(1L, "First", "Last", new Date(), "Male", "Address 1", "123456789"));
        patientList.add(new Patient(2L, "First2", "Last2", new Date(), "Female", "Address 2", "987654321"));
    }


    @Test
    public void testFindAllPatients() {
        // Arrange
        when(patientDAO.findAll()).thenReturn(patientList);

        // Act
        List<Patient> actualPatients = patientService.findAll();

        // Assert
        assertNotNull(actualPatients);
        assertEquals(patientList.size(), actualPatients.size());
        assertEquals(patientList, actualPatients);
        verify(patientDAO, times(1)).findAll();
    }


    @Test
    public void testFindPatientById() {
        // Arrange
        Long id = 1L;
        Patient expectedPatient = new Patient();
        when(patientDAO.findById(id)).thenReturn(Optional.of(expectedPatient));

        // Act
        Optional<Patient> actualPatient = patientService.findById(id);

        // Assert
        assertNotNull(actualPatient);
        assertEquals(expectedPatient, actualPatient.get());
        verify(patientDAO, times(1)).findById(id);
    }

    @Test
    public void testFindPatientByLastname() {
        // Arrange
        String lastname = "Doe";
        Patient expectedPatient = new Patient();
        when(patientDAO.findByLastname(lastname)).thenReturn(Optional.of(expectedPatient));

        // Act
        Optional<Patient> actualPatient = patientService.findByLastname(lastname);

        // Assert
        assertNotNull(actualPatient);
        assertEquals(expectedPatient, actualPatient.get());
        verify(patientDAO, times(1)).findByLastname(lastname);
    }

    @Test
    public void testAddPatient() {
        // Arrange
        Patient patientToAdd = new Patient();
        when(patientDAO.save(patientToAdd)).thenReturn(patientToAdd);

        // Act
        Patient addedPatient = patientService.addPatient(patientToAdd);

        // Assert
        assertNotNull(addedPatient);
        assertEquals(patientToAdd, addedPatient);
        verify(patientDAO, times(1)).save(patientToAdd);
    }

    @Test
    public void testUpdatePatientByLastname() {
        // Arrange
        String lastname = "Doe";
        Patient patientToUpdate = new Patient();
        when(patientDAO.findByLastname(lastname)).thenReturn(Optional.of(patientToUpdate));
        when(patientDAO.save(patientToUpdate)).thenReturn(patientToUpdate);

        // Act
        Patient updatedPatient = patientService.updatePatientByLastname(lastname, patientToUpdate);

        // Assert
        assertNotNull(updatedPatient);
        assertEquals(patientToUpdate, updatedPatient);
        verify(patientDAO, times(1)).findByLastname(lastname);
        verify(patientDAO, times(1)).save(patientToUpdate);
    }

    @Test
    public void testDeletePatientByLastname() {
        // Arrange
        String lastname = "Doe";
        Patient patientToDelete = new Patient();
        when(patientDAO.findByLastname(lastname)).thenReturn(Optional.of(patientToDelete));

        // Act
        Patient deletedPatient = patientService.deletePatientByLastname(lastname);

        // Assert
        verify(patientDAO, times(1)).findByLastname(lastname);
        verify(patientDAO, times(1)).delete(patientToDelete);
    }

    @Test
    public void testDeletePatientById() {
        // Arrange
        Long id = 1L;
        Patient patientToDelete = new Patient();
        when(patientDAO.findById(id)).thenReturn(Optional.of(patientToDelete));

        // Act
        Patient deletedPatient = patientService.deletePatientById(id);

        // Assert
        verify(patientDAO, times(1)).findById(id);
        verify(patientDAO, times(1)).delete(patientToDelete);
    }
}
