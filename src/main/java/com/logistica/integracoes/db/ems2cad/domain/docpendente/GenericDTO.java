package com.logistica.integracoes.db.ems2cad.domain.docpendente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GenericDTO {

    private String referencia;

    private LocalDate dataMov;
}
