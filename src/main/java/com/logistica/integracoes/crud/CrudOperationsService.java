package com.logistica.integracoes.crud;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class CrudOperationsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int performTransacationOperation(String query) {
        if (query == null) throw new AssertionError();

        return entityManager.createNativeQuery(query).executeUpdate();
    }
}
