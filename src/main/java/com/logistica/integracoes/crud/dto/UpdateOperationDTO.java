package com.logistica.integracoes.crud.dto;

import java.io.Serializable;

public class UpdateOperationDTO implements Serializable {

    private String tabela;

    private String values;

    private String where;

    private String rawQuery;

    public UpdateOperationDTO(String tabela, String values, String where, String rawQuery) {
        this.tabela = tabela;
        this.values = values;
        this.where = where;
        this.rawQuery = rawQuery;
    }

    public UpdateOperationDTO() {
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(String rawQuery) {
        this.rawQuery = rawQuery;
    }
}
