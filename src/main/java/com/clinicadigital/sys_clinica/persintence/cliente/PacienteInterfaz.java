package com.clinicadigital.sys_clinica.persintence.cliente;

import com.clinicadigital.sys_clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteInterfaz extends JpaRepository<Paciente,Long>, PacienteInterfazCustom {
}
