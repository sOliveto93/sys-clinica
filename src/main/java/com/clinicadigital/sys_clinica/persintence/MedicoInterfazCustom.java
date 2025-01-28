package com.clinicadigital.sys_clinica.persintence;

import org.springframework.data.jpa.repository.Query;

public interface MedicoInterfazCustom {

    boolean existsByCredencial(String credencial);
}
