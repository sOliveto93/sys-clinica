package com.clinicadigital.sys_clinica.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;

import java.util.Date;

public class PacienteDto {

    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellido;

    @Positive(message = "El dni debe ser un valor positivo")
    @Min(value = 10000000, message = "El DNI debe tener al menos 8 dígitos")
    @Max(value = 99999999, message = "El DNI debe tener como máximo 8 dígitos")
    private int dni;


    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private Date fecha_nac;


    @Email(message = "El email debe tener un formato válido")
    private String email;


    @Min(value = 10000000, message = "El DNI debe tener al menos 8 dígitos sin 11 o 15")
    @Max(value = 99999999, message = "El DNI debe tener como máximo 8 dígitos sin 11 o 15")
    private int telefono;

    private Boolean tieneOs;

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

    public Boolean getTieneOs() {
        return tieneOs;
    }

    public void setTieneOs(Boolean tieneOs) {
        this.tieneOs = tieneOs;
    }
}
