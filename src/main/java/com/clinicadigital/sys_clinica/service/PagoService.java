package com.clinicadigital.sys_clinica.service;

import com.clinicadigital.sys_clinica.Dto.PagoDto;
import com.clinicadigital.sys_clinica.entity.Pago;
import com.clinicadigital.sys_clinica.persintence.pago.PagoInterfaz;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class PagoService {

    @Autowired
    PagoInterfaz pagoI;

    public List<Pago> getAll() {
        return pagoI.findAll();
    }

    public Pago getById(Long id) {
        if (!pagoI.existsById(id)) {
            throw new NoSuchElementException("El pago con el id " + id + "no existe");
        }
        return pagoI.findById(id).get();
    }

    public void deletePago(Long id) {
        if (!pagoI.existsById(id)) {
            throw new NoSuchElementException("El pago con el id " + id + "no existe");
        }
        pagoI.deleteById(id);
    }

    public void putById(Long id, Pago newPago) {
        if (!pagoI.existsById(id)) {
            throw new NoSuchElementException("El pago con el id " + id + "no existe");
        }
        Pago pago = pagoI.findById(id).get();

        BeanUtils.copyProperties(newPago, pago, "id");
        pagoI.save(pago);
    }

    public void patchById(Long id, PagoDto dto) {
        if (!pagoI.existsById(id)) {
            throw new NoSuchElementException("El pago con el id " + id + "no existe");
        }
        Pago pago = pagoI.findById(id).get();

        if (dto.getOrigenFacturacion() != null) {
            pago.setOrigenFacturacion(dto.getOrigenFacturacion());
        }
        if (dto.getMedioPago() != null) {
            pago.setMedioPago(dto.getMedioPago());
        }
        if (dto.getSubTotal() != 0) {
            pago.setSubTotal(dto.getSubTotal());
        }
        if (dto.getTotal() != 0) {
            pago.setTotal(dto.getTotal());
        }
        if(dto.isDescuento()!= null){
            pago.setDescuento(dto.isDescuento());
        }

        pagoI.save(pago);
    }
}
