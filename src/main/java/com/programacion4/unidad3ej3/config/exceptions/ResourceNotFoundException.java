package com.programacion4.unidad3ej3.config.exceptions;

import java.util.List;

public class ResourceNotFoundException extends NotFoundException {

    public ResourceNotFoundException(String message) {
        super(message, List.of(message));
    }
}
