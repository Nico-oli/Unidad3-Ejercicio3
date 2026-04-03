package com.programacion4.unidad3ej3.config;

import java.time.Instant;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.programacion4.unidad3ej3.config.exceptions.ConflictException;
import com.programacion4.unidad3ej3.config.exceptions.CustomException;
import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones personalizadas
     * @param ex La excepción personalizada
     * Captura las excepciones personalizadas y las convierte en una respuesta HTTP con el estado de la excepción
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<Object>> handleCustomException(CustomException ex, HttpServletRequest request) {
        BaseResponse<Object> response = BaseResponse.builder()
                .status(ex.getStatus().value())
                .path(request.getRequestURI())
                .message(ex.getMessage())
                .errors(ex.getErrors())
                .timestamp(Instant.now().toString())
                .build();

        return new ResponseEntity<>(response, ex.getStatus());
    }

    /**
     * Maneja las excepciones de validación
     * @param ex La excepción de validación
     * @return La respuesta HTTP con el estado de la excepción
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .toList();

        BaseResponse<Object> response = BaseResponse.builder()
                .status(400)
                .path(request.getRequestURI())
                .message("Error de validación")
                .errors(errors)
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    /**
     * Maneja las excepciones genéricas
     * @param ex La excepción genérica
     * @return La respuesta HTTP con el estado de la excepción
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        BaseResponse<Object> response = BaseResponse.builder()
                .status(ex.getStatus().value())
                .path(request.getRequestURI())
                .message("Recurso no encontrado")
                .errors(List.of("Comuníquese con el administrador"))
                .timestamp(Instant.now().toString())
                .build();

        return new ResponseEntity<>(response, ex.getStatus());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<BaseResponse<Object>> handleConflict(ConflictException ex, HttpServletRequest request) {
        BaseResponse<Object> response = BaseResponse.builder()
                .status(ex.getStatus().value())
                .path(request.getRequestURI())
                .message(ex.getMessage())
                .errors(ex.getErrors())
                .timestamp(Instant.now().toString())
                .build();

        return new ResponseEntity<>(response, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneric(Exception ex, HttpServletRequest request) {
        // En producción, no mostrar el ex.getMessage() detallado para evitar fugas de info
        BaseResponse<Object> response = BaseResponse.builder()
                .status(500)
                .path(request.getRequestURI())
                .message("Ocurrió un error inesperado")
                .errors(List.of("Contacte al administrador"))
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.internalServerError().body(response);
    }
}
