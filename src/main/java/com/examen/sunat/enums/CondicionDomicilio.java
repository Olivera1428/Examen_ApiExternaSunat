package com.examen.sunat.enums;

public enum CondicionDomicilio {
    HABIDO, NO_HABIDO, PENDIENTE, DESCONOCIDO;

    public static CondicionDomicilio from(String value) {
        try {
            return CondicionDomicilio.valueOf(
                    value.trim()
                            .toUpperCase()
                            .replace(" ", "_")
            );
        } catch (Exception e) {
            return DESCONOCIDO;
        }
    }
}