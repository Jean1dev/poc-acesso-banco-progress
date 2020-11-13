package com.logistica.integracoes.crud;

import com.logistica.integracoes.exceptions.DetailErrorException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Date;

@Service
public class CrudOperationsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public int performTransacationOperation(String query) {
        if (query == null) throw new AssertionError();

        int executeUpdate = entityManager.createNativeQuery(query).executeUpdate();
        return executeUpdate;
    }
}
