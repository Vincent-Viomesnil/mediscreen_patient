package com.ocr.mediscreen.excepetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PatientNonCreeException extends RuntimeException {
    public PatientNonCreeException(String message) {
        super(message);
    }
}

