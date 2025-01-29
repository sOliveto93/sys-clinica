package com.clinicadigital.sys_clinica.persintence.cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PacienteCustomImp implements PacienteInterfazCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsByDni(int dni) {
        String jpql="SELECT COUNT(p) > 0 FROM Paciente p WHERE p.dni = :dni";
        TypedQuery<Long> query=entityManager.createQuery(jpql,Long.class);
        Long result=query.getSingleResult();
        return  result > 0;
    }
}
