//package com.ocr.mediscreen.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.ocr.mediscreen.dto.PatientDto;
//import com.ocr.mediscreen.exceptions.PatientNotFoundException;
//import com.ocr.mediscreen.service.PatientService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//class PatientControllerTest {
//
//    @Mock
//    private PatientService patientService;
//
//    @InjectMocks
//    private PatientController patientController;
//
//    @Mock
//    private PatientNotFoundException exceptionHandlerController;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//
//        mockMvc = MockMvcBuilders.standaloneSetup(patientController)
//                .setControllerAdvice(exceptionHandlerController)
//                .setHandlerExceptionResolvers()
//                .setObjectMapper(objectMapper)
//                .build();
//    }
//
//    @Test
//    void patientList_ReturnsListOfPatients() throws Exception {
//        // Arrange
//        PatientDto patient1 = new PatientDto(1L, "Firstname", "Lastname", LocalDate.of(1990, 01, 01), "M", "address", "010203040506");
//        PatientDto patient2 = new PatientDto(2L, "Prenom", "Nom", LocalDate.of(1990, 01, 01), "F", "postalcode", "1234567890");
//        List<PatientDto> patients = Arrays.asList(patient1, patient2);
//
//        when(patientService.findAll()).thenReturn(patients);
//
//        // Act & Assert
//        mockMvc.perform(get("/Patients"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(result -> {
//                    String contentAsString = result.getResponse().getContentAsString();
//                    List<PatientDto> responsePatients = Arrays.asList(new ObjectMapper().readValue(contentAsString, PatientDto[].class));
//
//                    // Assert the number of patients returned
//                    assertThat(responsePatients.size(), is(2));
//
//                    // Assert the properties of the first patient
//                    PatientDto responsePatient1 = responsePatients.get(0);
//                    assertThat(responsePatient1.getId(), is(1L));
//                    assertThat(responsePatient1.getFirstname(), is("Firstname"));
//                    assertThat(responsePatient1.getLastname(), is("Lastname"));
//                    assertThat(responsePatient1.getBirthdate(), is(LocalDate.of(1990, 01, 01)));
//                    assertThat(responsePatient1.getGender(), is("M"));
//                    assertThat(responsePatient1.getAddress(), is("address"));
//                    assertThat(responsePatient1.getPhonenumber(), is("010203040506"));
//
//                    // Assert the properties of the second patient
//                    PatientDto responsePatient2 = responsePatients.get(1);
//                    assertThat(responsePatient2.getId(), is(2L));
//                    assertThat(responsePatient2.getFirstname(), is("Prenom"));
//                    assertThat(responsePatient2.getLastname(), is("Nom"));
//                    assertThat(responsePatient2.getBirthdate(), is(LocalDate.of(1990, 01, 01)));
//                    assertThat(responsePatient2.getGender(), is("F"));
//                    assertThat(responsePatient2.getAddress(), is("postalcode"));
//                    assertThat(responsePatient2.getPhonenumber(), is("1234567890"));
//                });
//
//        verify(patientService, times(1)).findAll();
//        verifyNoMoreInteractions(patientService);
//    }
//
//}
