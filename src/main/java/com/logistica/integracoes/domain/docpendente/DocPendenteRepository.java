package com.logistica.integracoes.domain.docpendente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocPendenteRepository extends JpaRepository<DocPendente, String> {

    @Query(value = "select referencia from \"doc-pendente\" ", nativeQuery = true)
    List<DocPendente> findByRawQuery();

    @Query(value = "select referencia, dataMovto from DocPendente")
    List<IProjection> findByProjectionNonNativeQuery();
}
