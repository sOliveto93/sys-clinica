package com.clinicadigital.sys_clinica.service;

import com.clinicadigital.sys_clinica.Dto.PaqueteDto;
import com.clinicadigital.sys_clinica.entity.Paquete;
import com.clinicadigital.sys_clinica.persintence.paquete.PaqueteInterfaz;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class PaqueteService {

    @Autowired
    PaqueteInterfaz paqueteI;

    public List<Paquete> getAll() {
        return paqueteI.findAll();
    }

    public Paquete getById(Long id) {
        if (!paqueteI.existsById(id)) {
            throw new NoSuchElementException("El paquete con el id " + id + " no existe");
        }
        return paqueteI.findById(id).get();
    }

    public void deleteById(Long id) {
        if (!paqueteI.existsById(id)) {
            throw new NoSuchElementException("El paquete con el id " + id + " no existe");
        }
        paqueteI.deleteById(id);
    }

    public void putById(Long id, Paquete newPaquete) {
        if (!paqueteI.existsById(id)) {
            throw new NoSuchElementException("El paquete con el id " + id + " no existe");
        }
        Paquete paquete = paqueteI.findById(id).get();
        BeanUtils.copyProperties(newPaquete, paquete, "id");
        paqueteI.save(paquete);
    }

    public void patchById(Long id, PaqueteDto dto) {
        if (!paqueteI.existsById(id)) {
            throw new NoSuchElementException("El paquete con el id " + id + " no existe");
        }
        Paquete paquete=paqueteI.findById(id).get();
        if (dto.getCodigoPaquete() != 0) {
            paquete.setCodigoPaquete(dto.getCodigoPaquete());
        }
        if(dto.getPrecioPaquete()!= 0){
            paquete.setPrecioPaquete(dto.getPrecioPaquete());
        }
        paqueteI.save(paquete);
    }
}
