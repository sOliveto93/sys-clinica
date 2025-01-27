package com.clinicadigital.sys_clinica.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_hora",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConsulta;
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "medico_id",nullable = false)
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = true)
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "paquete_id", nullable = true)
    private Paquete paquete;
    @Column(name="monto",nullable = false)
    private double monto;
    @Column(name = "esta_pago",nullable = false)
    private boolean estaPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }
}
