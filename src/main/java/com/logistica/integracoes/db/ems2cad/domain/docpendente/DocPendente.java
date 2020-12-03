package com.logistica.integracoes.db.ems2cad.domain.docpendente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "\"doc-pendente\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocPendente implements Serializable {

    @Id
    @Column(name = "\"ep-codigo\"")
    private String epCodigo;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "\"data-movto\"")
    private Date dataMovto;
}
