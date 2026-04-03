package com.programacion4.unidad3ej3.config.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class NotFoundException extends CustomException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, List.of(message));
    }

    public NotFoundException(String message, List<String> errors) {
        super(message, HttpStatus.NOT_FOUND, errors);
    }
}
