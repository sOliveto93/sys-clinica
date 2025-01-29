package com.clinicadigital.sys_clinica.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crendencial")
    @NotNull(message = "La credencial no puede ser nula")
    @Size(min = 3, max = 50, message = "La credencial debe tener entre 3 y 50 caracteres")
    private String credencial;

    @Column(name = "especialidad", nullable = false)
    @NotNull(message = "La especialidad no puede ser nula")
    @Size(min = 3, max = 50, message = "La especialidad debe tener entre 3 y 50 caracteres")
    private String especialidad;

    @Column(name = "sueldo", nullable = false)
    @NotNull(message = "El sueldo no puede ser nulo")
    @Positive(message = "El sueldo debe ser un valor positivo")
    private Double sueldo;

    @Column(name = "nombre", nullable = false)
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @Column(name = "dni", nullable = false)
    @NotNull(message = "El DNI no puede ser nulo")
    @Min(value = 10000000, message = "El DNI debe tener al menos 8 dígitos")
    @Max(value = 99999999, message = "El DNI debe tener como máximo 8 dígitos")
    private int dni;

    @Column(name = "fecha_nac", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private Date fecha_nac;

    @Column(name = "email", nullable = true)
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Column(name = "telefono", nullable = true)
    @Positive(message = "El teléfono debe ser un valor positivo")
    private int telefono;

    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Consulta> consulta;


    public Long getId() {
        return id;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    public void setId(Long id) {
        this.id = id;
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
}
