package com.ocr.mediscreen.excepetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientIntrouvableException extends RuntimeException {

    public PatientIntrouvableException(String message) {
        super(message);
    }
}