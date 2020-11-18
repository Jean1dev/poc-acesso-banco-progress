package com.logistica.integracoes.domain.docpendente;

import org.springframework.beans.factory.annotation.Value;

public interface ICodigoReferncia {

    String getEpCodigo();

    @Value("#{target.referencia}")
    String getReferencia();
}
