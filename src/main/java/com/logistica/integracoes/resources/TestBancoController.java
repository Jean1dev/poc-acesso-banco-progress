package com.logistica.integracoes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("teste")
public class TestBancoController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity teste() {
        List list = entityManager.createNativeQuery("SELECT * FROM PUB.DEPOSITO WHERE 'cod-depos' = 'W05'")
                .getResultList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("teste2")
    public ResponseEntity teste2() {
        String query = "SELECT d.dt-emissao AS 'data-emissao'," +
                "       d.nro-docto AS 'documento-origem-id' " +
                "  FROM doc-fisico AS 'd', rat-lote AS 'r'" +
                "  WHERE d.'cod-estabel' = '1'" +
                "   AND d.'dt-emissao'  = '2020-11-11' " +
                "   AND d.'nro-docto'   = r.'nro-docto' " +
                "   AND r.'cod-depos'   = 'w05' ";

        List list = entityManager.createNativeQuery(query).getResultList();
        return ResponseEntity.ok(list);
    }
}
