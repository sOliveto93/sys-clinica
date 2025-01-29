package com.clinicadigital.sys_clinica.controller;

import com.clinicadigital.sys_clinica.Dto.MedicoDTO;
import com.clinicadigital.sys_clinica.entity.Medico;
import com.clinicadigital.sys_clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;
//las exception son manejadas por el globalExceptionHandler paquete utils

    @GetMapping("/getAll")
    public List<Medico> getAll() {
        return medicoService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Medico> getById(@PathVariable Long id) {
        Medico medico = medicoService.getById(id);
        return ResponseEntity.ok(medico);
    }

    @PostMapping("/addMedico")
    public ResponseEntity<String> addMedico(@RequestBody Medico medico) {
        ResponseEntity<String> result = medicoService.addMedico(medico);
        return result;
    }

    @DeleteMapping("/deleteMedico/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable Long id) {
        return medicoService.deleteById(id);
    }

    @PutMapping("/putMedico/{id}")
    public ResponseEntity<String> putMedico(@PathVariable Long id,@RequestBody @Validated Medico medico){
        return medicoService.putById(id,medico);
    }

    @PatchMapping("/patchMedico/{id}")
    public ResponseEntity<String> patchmedico(@PathVariable Long id, @RequestBody @Validated MedicoDTO medicodto){
    return medicoService.patchMedico(id,medicodto);
    }
}
