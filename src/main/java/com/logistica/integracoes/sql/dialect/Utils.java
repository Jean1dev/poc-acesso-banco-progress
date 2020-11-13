package com.logistica.integracoes.sql.dialect;

public final class Utils {

    public static String descobreTipo(String valor) {
        if (ehNumero(valor)) {
            return valor;
        }

        if (ehSisDateOuNull(valor)) {
            return valor;
        }

        return "'" + valor + "'";
    }

    private static boolean ehSisDateOuNull(String valor) {
        return valor.equals("sysdate") || valor.equals("NULL");
    }

    private static Boolean ehNumero(String valor) {
        try {
            Double of = Double.valueOf(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
