package com.logistica.integracoes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("sql")
public class TestBancoController {

    @PersistenceContext(unitName = "ems2mov")
    private EntityManager ems2mov;

    @PersistenceContext(unitName = "ems2cad")
    private EntityManager ems2Cad;

    @GetMapping
    public ResponseEntity teste() {
        List resultList = ems2Cad.createNativeQuery("SELECT \"cod-emitente\", \"cod-bem\", \"cod_espec_bem\", \"des-onus\", \"log-seguro\", \"log-penhor\", \"dat-penhor\", \"des-bem\", \"val-bem\", \"char-1\", \"char-2\", \"dec-1\", \"dec-2\", \"int-1\", \"int-2\", \"log-1\", \"log-2\", \"data-1\", \"data-2\", \"num-seq-bem\"\n" +
                "FROM PUB.\"gg-bem\"\n").getResultList();

        List list = ems2mov.createNativeQuery("SELECT * FROM PUB.\"mi-filtro\" ")
                .getResultList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("doc-fisico")
    public ResponseEntity selectFromDocFisico() {
        String query = "SELECT d.dt-emissao AS 'data-emissao'," +
                "       d.nro-docto AS 'documento-origem-id' " +
                "  FROM doc-fisico AS 'd', rat-lote AS 'r'" +
                "  WHERE d.'cod-estabel' = '1'" +
                "   AND d.'dt-emissao'  = '2020-11-11' " +
                "   AND d.'nro-docto'   = r.'nro-docto' " +
                "   AND r.'cod-depos'   = 'w05' ";

        List list = ems2mov.createNativeQuery(query).getResultList();
        return ResponseEntity.ok(list);
    }
}
