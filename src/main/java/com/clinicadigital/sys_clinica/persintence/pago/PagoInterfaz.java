package com.clinicadigital.sys_clinica.persintence.pago;

import com.clinicadigital.sys_clinica.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoInterfaz extends JpaRepository<Pago,Long> {
}
