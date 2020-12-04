package com.logistica.integracoes.db.ems2mov.domain.docfisico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "\"doc-fisico\"")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocFisico implements Serializable {

    @Id
    @Column(name = "\"nro-docto\"")
    private String documento;

    @Column(name = "\"dt-emissao\"")
    private LocalDate dataEmissao;
}
