package com.logistica.integracoes.domain.turno;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"turno-dia\"")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Turno {

    @Id
    @Column(name = "\"cod-model-turno\"")
    private String codModelTurno;

    @Column(name = "\"num-turno\"")
    private String numTurmo;
}
