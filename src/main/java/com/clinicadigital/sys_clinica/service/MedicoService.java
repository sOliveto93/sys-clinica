package com.clinicadigital.sys_clinica.service;

import com.clinicadigital.sys_clinica.entity.Medico;
import com.clinicadigital.sys_clinica.persintence.MedicoInterfaz;
import com.clinicadigital.sys_clinica.persintence.MedicoInterfazCustom;
import com.clinicadigital.sys_clinica.utils.MedicoAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoInterfaz medicoI;

    public List<Medico> getAll() {
        return medicoI.findAll();
    }

    public Medico getById(Long id) {
        return medicoI.findById(id).orElseThrow(() -> new NoSuchElementException("Medico con ID " + id + " no encontrado"));
    }

    public ResponseEntity<String> addMedico(Medico medico) {
        if (medico.getCredencial().trim().isEmpty()) {
            throw new IllegalArgumentException("credencial del medico esta vacia");
        } else if (medicoI.existsByCredencial(medico.getCredencial())) {
            throw new MedicoAlreadyExistsException("El medico con la credencia " + medico.getCredencial() + " ya existe");
        }
        medicoI.save(medico);
        return ResponseEntity.ok("Medico creado con exito");
    }

    public ResponseEntity<String> deleteById(long id) {
        if (!medicoI.existsById(id)) {
            throw new NoSuchElementException("El doctor con id " + id + " no existe");
        }
        medicoI.deleteById(id);
        return ResponseEntity.ok("Medico eliminado con exito");
    }
}
