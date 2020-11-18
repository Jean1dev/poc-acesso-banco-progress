package com.logistica.integracoes.domain.docpendente;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "typeCustomProjection", types = {DocPendente.class})
public interface IProjection {

    String getReferencia();

    Date getDataMovto();
}
