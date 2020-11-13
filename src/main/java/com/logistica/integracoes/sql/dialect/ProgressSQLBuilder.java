package com.logistica.integracoes.sql.dialect;

import java.util.List;

public interface ProgressSQLBuilder<T> {

    T addCampo(String campo);

    T addCampos(List<String> campos);

    T addValue(String value);

    T addValues(List<String> values);

    T addTable(String table);

    String build();
}
