package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo_servicio", nullable = false)
    private String codigoServicio;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    @OneToMany(mappedBy = "servicio")
    private List<PaqueteServicio> paqueteServicios;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PaqueteServicio> getPaqueteServicios() {
        return paqueteServicios;
    }

    public void setPaqueteServicios(List<PaqueteServicio> paqueteServicios) {
        this.paqueteServicios = paqueteServicios;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
