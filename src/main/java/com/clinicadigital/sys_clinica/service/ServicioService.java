package com.clinicadigital.sys_clinica.service;

import com.clinicadigital.sys_clinica.Dto.ServicioDto;
import com.clinicadigital.sys_clinica.entity.Medico;
import com.clinicadigital.sys_clinica.entity.Servicio;
import com.clinicadigital.sys_clinica.persintence.Servicio.ServicioInterfaz;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class ServicioService {

    @Autowired
    ServicioInterfaz servicioI;

    public List<Servicio> getAll(Long id){
        return servicioI.findAll();
    }
    public Servicio getById(Long id){
        return servicioI.findById(id).orElseThrow(()->new NoSuchElementException("Servicio con ID " + id + " no encontrado"));
    }

    public void addServicio(ServicioDto dto ){
        Servicio servicio=new Servicio();

        servicio.setNombre(dto.getNombre());
        servicio.setCodigoServicio(dto.getCodigoServicio());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        servicioI.save(servicio);
    }

    public void putById(Long id,Servicio newServicio){
        if(!servicioI.existsById(id)){
            throw new NoSuchElementException("Servicio con ID " + id + " no encontrado");
        }
        Servicio servicio=servicioI.findById(id).get();
        BeanUtils.copyProperties(newServicio,servicio, "id");
        servicioI.save(servicio);
    }
    public void patchById(Long id,ServicioDto dto){
        if(!servicioI.existsById(id)){
            throw new NoSuchElementException("Servicio con ID " + id + " no encontrado");
        }
        Servicio servicio=servicioI.findById(id).get();

        if (dto.getCodigoServicio() != null) {
            servicio.setCodigoServicio(dto.getCodigoServicio());
        }
        if(dto.getNombre() != null){
            servicio.setNombre(dto.getNombre());
        }
        if(dto.getDescripcion() != null){
            servicio.setDescripcion(dto.getCodigoServicio());
        }
        if(dto.getPrecio() != 0){
            servicio.setPrecio(dto.getPrecio());
        }
//---------------------------------------------
        servicioI.save(servicio);

    }
}
