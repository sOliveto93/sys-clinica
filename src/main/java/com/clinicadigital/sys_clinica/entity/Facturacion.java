package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "facturacion")
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ganancia_diaria",nullable = false)
    private double gananciasDiarias;
    @Column(name = "ganancia_mensual",nullable = true)
    private double gananciasMensuales;
    @Column(name = "fecha_informe",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracionInforme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGananciasDiarias() {
        return gananciasDiarias;
    }

    public void setGananciasDiarias(double gananciasDiarias) {
        this.gananciasDiarias = gananciasDiarias;
    }

    public double getGananciasMensuales() {
        return gananciasMensuales;
    }

    public void setGananciasMensuales(double gananciasMensuales) {
        this.gananciasMensuales = gananciasMensuales;
    }

    public Date getFechaGeneracionInforme() {
        return fechaGeneracionInforme;
    }

    public void setFechaGeneracionInforme(Date fechaGeneracionInforme) {
        this.fechaGeneracionInforme = fechaGeneracionInforme;
    }
}
