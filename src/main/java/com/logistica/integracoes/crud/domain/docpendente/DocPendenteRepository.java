package com.logistica.integracoes.crud.domain.docpendente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocPendenteRepository extends JpaRepository<DocPendente, String>, JpaSpecificationExecutor<DocPendente> {

    @Query(value = "select d.referencia from PUB.\"doc-pendente\" d", nativeQuery = true)
    List<ICodigoReferncia> findByProjection();

    @Query(value = "select referencia, dataMovto from DocPendente")
    List<IProjection> findByProjectionNonNativeQuery();
}
