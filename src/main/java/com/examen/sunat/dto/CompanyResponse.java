package com.examen.sunat.dto;

import com.examen.sunat.enums.CondicionDomicilio;
import com.examen.sunat.enums.EstadoContribuyente;

public record CompanyResponse(
        String ruc,
        String razonSocial,
        EstadoContribuyente estado,
        CondicionDomicilio condicion,
        String direccion,
        String ubigeo,
        String departamento,
        String provincia,
        String distrito,
        boolean esAgenteRetencion,
        boolean esBuenContribuyente
) {}