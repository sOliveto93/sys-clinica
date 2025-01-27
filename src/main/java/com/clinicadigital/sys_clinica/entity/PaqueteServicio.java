package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paquete_servicio")
public class PaqueteServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paquete_id",nullable = false)
    private Paquete paquete;

    @ManyToOne
    @JoinColumn(name = "servicio_id",nullable = false)
    private Servicio servicio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
