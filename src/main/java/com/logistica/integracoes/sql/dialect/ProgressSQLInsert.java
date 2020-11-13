package com.logistica.integracoes.sql.dialect;

import java.util.ArrayList;
import java.util.List;

import static com.logistica.integracoes.sql.dialect.Utils.descobreTipo;

public class ProgressSQLInsert implements ProgressSQLBuilder<ProgressSQLInsert> {

    private List<String> camposInsert = new ArrayList<>();

    private List<String> camposValues = new ArrayList<>();

    private String tabela;

    private ProgressSQLInsert() {
    }

    public static ProgressSQLInsert create() {
        return new ProgressSQLInsert();
    }

    public ProgressSQLInsert addCampo(String campo) {
        camposInsert.add(campo);
        return this;
    }

    @Override
    public ProgressSQLInsert addCampos(List<String> campos) {
        this.camposInsert.clear();
        this.camposInsert.addAll(campos);
        return this;
    }

    public ProgressSQLInsert addValue(String valor) {
        camposValues.add(valor);
        return this;
    }

    @Override
    public ProgressSQLInsert addValues(List<String> values) {
        this.camposValues.clear();
        this.camposValues.addAll(values);
        return this;
    }

    public ProgressSQLInsert addTable(String tabela) {
        this.tabela = tabela.replace("'", "\"");
        return this;
    }

    @Override
    public String build() {
        String rawQuery = "INSERT INTO " + tabela +  " (";

        int sizeCamposInsert = camposInsert.size();
        for (int i = 0; i < sizeCamposInsert; i++) {
            if (i == sizeCamposInsert - 1) {
                rawQuery += "\"" + camposInsert.get(i) + "\"" + ")";
            } else {
                rawQuery += "\"" + camposInsert.get(i) + "\"" + ",";
            }
        }

        rawQuery += " VALUES (";

        int sizeCamposValue = camposValues.size();
        for (int i = 0; i < sizeCamposValue; i++) {
            if (i == sizeCamposValue - 1) {
                rawQuery += descobreTipo(camposValues.get(i)) + ")";
            } else {
                rawQuery += descobreTipo(camposValues.get(i)) + ",";
            }
        }

        return rawQuery;
    }
}
