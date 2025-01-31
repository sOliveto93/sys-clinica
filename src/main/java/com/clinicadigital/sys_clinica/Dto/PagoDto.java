package com.clinicadigital.sys_clinica.Dto;

import java.util.Date;

public class PagoDto {
    private String origenFacturacion;
    private String medioPago;
    private double subTotal;
    private Boolean descuento;
    private double total;

    public String getOrigenFacturacion() {
        return origenFacturacion;
    }

    public void setOrigenFacturacion(String origenFacturacion) {
        this.origenFacturacion = origenFacturacion;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(Boolean descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
