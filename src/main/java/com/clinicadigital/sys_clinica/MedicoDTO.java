package com.clinicadigital.sys_clinica;
import jakarta.validation.constraints.*;

import java.util.Date;

public class MedicoDTO {
    @Size(min = 3, max = 50, message = "La especialidad debe tener entre 3 y 50 caracteres")
    private String especialidad;

    @Size(min = 2, max = 50, message = "La credencial debe tener entre 2 y 50 caracteres")
    private String credencial;

    @Positive(message = "El sueldo debe ser un valor positivo")
    private Double sueldo;

    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @Min(value = 10000000, message = "El DNI debe tener al menos 8 dígitos")
    @Max(value = 99999999, message = "El DNI debe tener como máximo 8 dígitos")
    private Integer dni;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private Date fecha_nac;

    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Positive(message = "El teléfono debe ser un valor positivo")
    private Integer telefono;

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
