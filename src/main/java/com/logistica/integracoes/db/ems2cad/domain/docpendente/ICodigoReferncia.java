package com.logistica.integracoes.db.ems2cad.domain.docpendente;

import org.springframework.beans.factory.annotation.Value;

public interface ICodigoReferncia {

    String getEpCodigo();

    @Value("#{target.referencia}")
    String getReferencia();
}
