package com.ocr.mediscreen.exceptions;

import org.springframework.http.HttpStatus;


public class PatientIntrouvableException extends RuntimeException {
    public PatientIntrouvableException(String message) {
        super(message);
    }
}