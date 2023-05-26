package com.ocr.mediscreen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PatientNonCreeException extends RuntimeException {
    public PatientNonCreeException(String message) {
        super(message);
    }
}

