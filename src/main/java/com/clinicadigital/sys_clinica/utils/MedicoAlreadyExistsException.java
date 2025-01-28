package com.clinicadigital.sys_clinica.utils;

public class MedicoAlreadyExistsException extends RuntimeException{

    public MedicoAlreadyExistsException(String message){
        super(message);
    }
}
