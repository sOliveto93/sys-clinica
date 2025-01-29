package com.clinicadigital.sys_clinica.service;

import com.clinicadigital.sys_clinica.Dto.PacienteDto;
import com.clinicadigital.sys_clinica.entity.Medico;
import com.clinicadigital.sys_clinica.entity.Paciente;
import com.clinicadigital.sys_clinica.persintence.cliente.PacienteInterfaz;
import com.clinicadigital.sys_clinica.utils.EntityAlreadyExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PacienteService {

    @Autowired
    PacienteInterfaz pacienteI;

    public List<Paciente> getAll() {
        return pacienteI.findAll();
    }

    public Paciente getById(Long id) {
        return pacienteI.findById(id).orElseThrow(() -> new NoSuchElementException("Paciente con id " + id + " no encontrado"));
    }

    public ResponseEntity<String> addPaciente(Paciente paciente) {
        if (pacienteI.existsByDni(paciente.getDni())) {
            throw new EntityAlreadyExistsException("El Paciente con el dni" + paciente.getDni() + " ya existe");
        }
        pacienteI.save(paciente);
        return ResponseEntity.ok("Paciente creado con exito");
    }

    public ResponseEntity<String> deleteById(Long id) {
        if (!pacienteI.existsById(id)) {
            throw new NoSuchElementException("Paciente con id " + id + " no encontrado");
        }
        pacienteI.deleteById(id);
        return ResponseEntity.ok("Paciente eliminado con exito");
    }

    public ResponseEntity<String> putById(Long id, Paciente newPaciente) {
        if (!pacienteI.existsById(id)) {
            throw new NoSuchElementException("El paciente con id " + id + " no existe");
        }
        Paciente paciente = pacienteI.findById(id).get();
        BeanUtils.copyProperties(newPaciente, paciente, "id");
        pacienteI.save(paciente);
        return ResponseEntity.ok("Paciente actualizado con exito");
    }

    public ResponseEntity<String> patchById(Long id, PacienteDto pacienteDto) {
        if (!pacienteI.existsById(id)) {
            throw new NoSuchElementException("El paciente con id " + id + " no existe");
        }
        Paciente paciente = pacienteI.findById(id).get();
        // Copiar solo las propiedades no nulas
        if (pacienteDto.getNombre() != null) {
            paciente.setNombre(pacienteDto.getNombre());
        }
        if (pacienteDto.getApellido() != null) {
            paciente.setApellido(pacienteDto.getApellido());
        }
        if (pacienteDto.getDni() != 0) {
            paciente.setDni(pacienteDto.getDni());
        }
        if (pacienteDto.getFecha_nac() != null) {
            paciente.setFecha_nac(pacienteDto.getFecha_nac());
        }
        if (pacienteDto.getEmail() != null) {
            paciente.setEmail(pacienteDto.getEmail());
        }
        if (pacienteDto.getTelefono() != 0) {
            paciente.setTelefono(pacienteDto.getTelefono());
        }
        if (pacienteDto.getTieneOs() != null) {
            paciente.setTieneOs(pacienteDto.getTieneOs());
        }

        pacienteI.save(paciente);
        return ResponseEntity.ok("Paciente actualizado con exito");

    }
}
