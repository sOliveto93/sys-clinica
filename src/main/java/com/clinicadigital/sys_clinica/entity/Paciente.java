package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre",nullable = false)
    private String nombre;
    @Column(name="apellido",nullable = false)
    private String apellido;
    @Column(name="dni",nullable = false)
    private int dni;
    @Column(name="fecha_nac",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_nac;
    @Column(name="email",nullable = true)
    private String email;
    @Column(name="telefono",nullable = true)
    private int telefono;
    @Column(name="tiene_obra_social",nullable = false)
    private boolean tieneOs;

    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    private List<Pago> pagos;
    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    private List<Consulta> consultas;

    public Long getId() {
        return id;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isTieneOs() {
        return tieneOs;
    }

    public void setTieneOs(boolean tieneOs) {
        this.tieneOs = tieneOs;
    }
}
