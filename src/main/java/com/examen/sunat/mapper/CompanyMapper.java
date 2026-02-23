package com.examen.sunat.mapper;

import com.examen.sunat.dto.CompanyResponse;
import com.examen.sunat.dto.SunatRucResponse;
import com.examen.sunat.entity.Company;
import com.examen.sunat.enums.CondicionDomicilio;
import com.examen.sunat.enums.EstadoContribuyente;

public class CompanyMapper {

    public static Company toEntity(SunatRucResponse dto) {
        Company c = new Company();

        c.setRuc(dto.numero_documento());
        c.setRazonSocial(dto.razon_social());
        c.setDireccion(dto.direccion());
        c.setUbigeo(dto.ubigeo());
        c.setDepartamento(dto.departamento());
        c.setProvincia(dto.provincia());
        c.setDistrito(dto.distrito());
        c.setEsAgenteRetencion(dto.es_agente_retencion());
        c.setEsBuenContribuyente(dto.es_buen_contribuyente());

        c.setEstado(EstadoContribuyente.from(dto.estado()));
        c.setCondicion(CondicionDomicilio.from(dto.condicion()));

        return c;
    }

    public static CompanyResponse toResponse(Company company) {
        return new CompanyResponse(
                company.getRuc(),
                company.getRazonSocial(),
                company.getEstado(),
                company.getCondicion(),
                company.getDireccion(),
                company.getUbigeo(),
                company.getDepartamento(),
                company.getProvincia(),
                company.getDistrito(),
                company.isEsAgenteRetencion(),
                company.isEsBuenContribuyente()
        );
    }
    public static void updateEntity(Company company, SunatRucResponse dto) {
        company.setRazonSocial(dto.razon_social());
        company.setEstado(EstadoContribuyente.from(dto.estado()));
        company.setCondicion(CondicionDomicilio.from(dto.condicion()));
        company.setDireccion(dto.direccion());
        company.setUbigeo(dto.ubigeo());
        company.setDepartamento(dto.departamento());
        company.setProvincia(dto.provincia());
        company.setDistrito(dto.distrito());
        company.setEsAgenteRetencion(dto.es_agente_retencion());
        company.setEsBuenContribuyente(dto.es_buen_contribuyente());
    }
}