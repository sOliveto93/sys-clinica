package com.clinicadigital.sys_clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Prueba {

    @GetMapping("/saludo")
    public String saludo(){
        return "hola mundo";
    }

}
