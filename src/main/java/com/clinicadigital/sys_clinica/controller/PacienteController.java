package com.clinicadigital.sys_clinica.controller;

import com.clinicadigital.sys_clinica.Dto.PacienteDto;
import com.clinicadigital.sys_clinica.entity.Paciente;
import com.clinicadigital.sys_clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/getAll")
    public List<Paciente> getAll() {
    return pacienteService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Paciente getById(@PathVariable Long id){
        return pacienteService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPaciente(@RequestBody @Validated Paciente paciente){
        return pacienteService.addPaciente(paciente);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return pacienteService.deleteById(id);
    }

    @PutMapping("/putById/{id}")
    public ResponseEntity<String> putById(@PathVariable Long id, @RequestBody @Validated Paciente paciente){
        return pacienteService.putById(id,paciente);
    }

    @PatchMapping("/patchById/{id}")
    public ResponseEntity<String>patchById(@PathVariable Long id, @RequestBody @Validated PacienteDto pacienteDto){
        return pacienteService.patchById(id,pacienteDto);
    }

}
