package com.clinicadigital.sys_clinica.controller;

import com.clinicadigital.sys_clinica.entity.Medico;
import com.clinicadigital.sys_clinica.persintence.MedicoInterfaz;
import com.clinicadigital.sys_clinica.service.MedicoService;
import com.clinicadigital.sys_clinica.utils.ErrorResponseCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @GetMapping("/getAll")
    public List<Medico> getAll(){
        return medicoService.getAll();
    }
//las exception son manejadas por el globalExceptionHandler paquete utils
    @GetMapping("/getById/{id}")
    public ResponseEntity<Medico> getById(@PathVariable Long id){
        Medico medico=medicoService.getById(id);
        return ResponseEntity.ok(medico);
    }

    @PostMapping("/addMedico")
    public ResponseEntity<String> addMedico(@RequestBody Medico medico){
      ResponseEntity<String> result=medicoService.addMedico(medico);
       return result;
    }
    @DeleteMapping("/deleteMedico/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable Long id){
        return medicoService.deleteById(id);
    }
}
