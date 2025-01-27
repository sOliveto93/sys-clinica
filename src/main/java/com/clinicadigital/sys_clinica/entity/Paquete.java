package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paquete")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_paquete",nullable = false)
    private int codigoPaquete;

    @Column(name = "paquete_precio",nullable = false)
    private double precioPaquete;

    @OneToMany(mappedBy = "paquete")
    private List<PaqueteServicio> paqueteServicios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public double getPrecioPaquete() {
        return precioPaquete;
    }

    public void setPrecioPaquete(double precioPaquete) {
        this.precioPaquete = precioPaquete;
    }

    public List<PaqueteServicio> getPaqueteServicios() {
        return paqueteServicios;
    }

    public void setPaqueteServicios(List<PaqueteServicio> paqueteServicios) {
        this.paqueteServicios = paqueteServicios;
    }
}
