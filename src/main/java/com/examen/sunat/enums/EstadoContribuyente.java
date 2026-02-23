package com.examen.sunat.enums;

public enum EstadoContribuyente {
    ACTIVO, BAJA, SUSPENDIDO, DESCONOCIDO;

    public static EstadoContribuyente from(String value) {
        try {
            return EstadoContribuyente.valueOf(
                    value.trim().toUpperCase()
            );
        } catch (Exception e) {
            return DESCONOCIDO;
        }
    }
}