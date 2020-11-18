package com.logistica.integracoes.domain.docpendente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping(path = "doc-pendente")
public class DocPendenteController {

    @Autowired
    private DocPendenteRepository repository;

    @PersistenceContext
    private EntityManager em;

    @GetMapping
    public ResponseEntity getAllByProjection() {
        List<DocPendente> all = repository.findAll();
        List<IProjection> teste = repository.findByProjectionNonNativeQuery();
        return ResponseEntity.ok(repository.findByRawQuery());
    }

    @GetMapping(path = "by-em")
    public List<IProjection> getAllByEm() {
        List resultList = em.createNativeQuery("select d.referencia, d.\"data-movto\" from PUB.\"doc-pendente\" d", IProjection.class)
                .getResultList();

        return em.createQuery("select referencia as referencia, dataMovto from DocPendente")
                .getResultList();
    }
}
