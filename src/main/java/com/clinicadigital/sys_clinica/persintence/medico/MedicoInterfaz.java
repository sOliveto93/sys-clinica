package com.clinicadigital.sys_clinica.persintence.medico;

import com.clinicadigital.sys_clinica.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoInterfaz extends JpaRepository<Medico, Long>,MedicoInterfazCustom {

}
