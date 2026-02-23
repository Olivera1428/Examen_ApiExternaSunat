package com.examen.sunat.mapper;

import com.examen.sunat.dto.ConsultaResponse;
import com.examen.sunat.entity.Consulta;

public class ConsultaMapper {
    public static ConsultaResponse toResponse(Consulta consulta) {
        return new ConsultaResponse(
                consulta.getRucConsultado(),
                consulta.getResultado(),
                consulta.getMensajeError(),
                consulta.getProviderStatusCode(),
                consulta.getCreatedAt()
        );
    }
}
