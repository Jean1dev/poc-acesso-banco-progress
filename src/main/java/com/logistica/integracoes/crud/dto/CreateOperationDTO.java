package com.logistica.integracoes.crud.dto;

import java.io.Serializable;
import java.util.List;

public class CreateOperationDTO implements Serializable {

    private String tabela;

    private List<String> campos;

    private List<String> valores;

    private String rawQuery;

    public CreateOperationDTO(String tabela, List<String> campos, List<String> valores, String rawQuery) {
        this.tabela = tabela;
        this.campos = campos;
        this.valores = valores;
        this.rawQuery = rawQuery;
    }

    public CreateOperationDTO() {
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public List<String> getCampos() {
        return campos;
    }

    public void setCampos(List<String> campos) {
        this.campos = campos;
    }

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }

    public String getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(String rawQuery) {
        this.rawQuery = rawQuery;
    }
}
