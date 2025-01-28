package com.clinicadigital.sys_clinica.utils;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName,Long entityId){
        super(entityName + " con id" + entityId+" no encontrado");
    }
}
