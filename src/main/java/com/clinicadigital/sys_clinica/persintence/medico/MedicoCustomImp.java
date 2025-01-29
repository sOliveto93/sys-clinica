package com.clinicadigital.sys_clinica.persintence.medico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class MedicoCustomImp implements MedicoInterfazCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsByCredencial(String credencial){

        String jpql="SELECT COUNT(m) > 0 FROM Medico m WHERE m.credencial = :credencial";
        TypedQuery<Long> query=entityManager.createQuery(jpql,Long.class);
        Long result=query.getSingleResult();
        return  result > 0;
    }
}
