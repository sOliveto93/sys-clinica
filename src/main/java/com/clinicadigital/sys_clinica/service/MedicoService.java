package com.clinicadigital.sys_clinica.service;

import com.clinicadigital.sys_clinica.Dto.MedicoDTO;
import com.clinicadigital.sys_clinica.entity.Medico;
import com.clinicadigital.sys_clinica.persintence.medico.MedicoInterfaz;
import com.clinicadigital.sys_clinica.utils.EntityAlreadyExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
            throw new EntityAlreadyExistsException("El medico con la credencia " + medico.getCredencial() + " ya existe");
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
    public ResponseEntity<String> putById(Long id,Medico newMedico){
        if(!medicoI.existsById(id)){
            throw  new NoSuchElementException("El doctor con id " + id + " no existe");
        }
        Medico medico=medicoI.findById(id).get();
        BeanUtils.copyProperties(newMedico,medico, "id"); // Excluimos el 'id' para no sobrescribirlo
        medicoI.save(medico);
        return ResponseEntity.ok("medico actualizado con exito");
    }
    public ResponseEntity<String> patchById(Long id, MedicoDTO medicoDto){
        if(!medicoI.existsById(id)){
            throw  new NoSuchElementException("El doctor con id " + id + " no existe");
        }
        Medico medico=medicoI.findById(id).get();
        // Copiar solo las propiedades no nulas
        if (medicoDto.getCredencial() != null) {
            medico.setCredencial(medicoDto.getCredencial());
        }
        if (medicoDto.getEspecialidad() != null) {
            medico.setEspecialidad(medicoDto.getEspecialidad());
        }
        if (medicoDto.getSueldo() != null) {
            medico.setSueldo(medicoDto.getSueldo());
        }
        if (medicoDto.getNombre() != null) {
            medico.setNombre(medicoDto.getNombre());
        }
        if (medicoDto.getApellido() != null) {
            medico.setApellido(medicoDto.getApellido());
        }
        if (medicoDto.getDni() != 0) {  // Suponiendo que el dni no debe ser 0
            medico.setDni(medicoDto.getDni());
        }
        if (medicoDto.getFecha_nac() != null) {
            medico.setFecha_nac(medicoDto.getFecha_nac());
        }
        if (medicoDto.getEmail() != null) {
            medico.setEmail(medicoDto.getEmail());
        }
        if (medicoDto.getTelefono() != 0) {  // Si 0 no es un valor válido para teléfono
            medico.setTelefono(medicoDto.getTelefono());
        }

        medicoI.save(medico);

        return ResponseEntity.ok("Medico actualizado con éxito");
    }
}
