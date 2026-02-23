package com.examen.sunat.dto;

import com.examen.sunat.enums.ResultadoConsulta;

import java.time.LocalDateTime;

public record ConsultaResponse(
        String rucConsultado,
        ResultadoConsulta resultado,
        String mensajeError,
        Integer providerStatusCode,
        LocalDateTime fechaConsulta
) {}