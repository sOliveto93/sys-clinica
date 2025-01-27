package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "origen_facturacion", nullable = false)
    private String origenFacturacion;
    @Column(name = "medio_de_pago", nullable = false)
    private String medioPago;
    @Column(name = "sub_total", nullable = false)
    private double subTotal;
    @Column(name = "descuento", nullable = false)
    private boolean descuento;
    @Column(name = "total", nullable = false)
    private double total;
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
