package com.clinicadigital.sys_clinica.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseCustom> handleMedicoNotFound(EntityNotFoundException ex) {
        ErrorResponseCustom error = new ErrorResponseCustom(ex.getMessage(),"ENTITY_NOT_FOUND");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseCustom> handleNoSuchElementException(NoSuchElementException ex) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(), "ENTITY_NOT_FOUND");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseCustom> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(),"INVALID_ARGUMENT");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseCustom> handleNullPointerException(NullPointerException ex) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(), "NULL_POINTER_ERROR");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseCustom> handleException(Exception ex) {
        ErrorResponseCustom errorResponse = new ErrorResponseCustom(ex.getMessage(),"Error interno del servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


}
