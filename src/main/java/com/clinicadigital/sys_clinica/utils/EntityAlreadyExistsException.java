package com.clinicadigital.sys_clinica.utils;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
