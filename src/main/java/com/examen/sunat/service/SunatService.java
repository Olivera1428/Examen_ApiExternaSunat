package com.examen.sunat.service;

import com.examen.sunat.client.DecoletaSunatFeignClient;
import com.examen.sunat.dto.CompanyResponse;
import com.examen.sunat.dto.ConsultaResponse;
import com.examen.sunat.dto.SunatRucResponse;
import com.examen.sunat.entity.Company;
import com.examen.sunat.entity.Consulta;
import com.examen.sunat.enums.ResultadoConsulta;
import com.examen.sunat.exception.InvalidRucException;
import com.examen.sunat.exception.ProviderException;
import com.examen.sunat.mapper.CompanyMapper;
import com.examen.sunat.mapper.ConsultaMapper;
import com.examen.sunat.repository.CompanyRepository;
import com.examen.sunat.repository.ConsultaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SunatService {

    private final DecoletaSunatFeignClient sunatClient;
    private final CompanyRepository companyRepository;
    private final ConsultaRepository consultaRepository;
    @Value("${decoleta.token}")
    private String token;

    public SunatService(DecoletaSunatFeignClient sunatClient, CompanyRepository companyRepository, ConsultaRepository consultaRepository) {
        this.sunatClient = sunatClient;
        this.companyRepository = companyRepository;
        this.consultaRepository = consultaRepository;
    }

    public CompanyResponse consultarRuc(String ruc) {

        if (!ruc.matches("\\d{11}")) {
            throw new InvalidRucException("RUC debe tener exactamente 11 dígitos");
        }

        try {

            SunatRucResponse dto = sunatClient.getRuc(ruc);

            Company company = companyRepository.findByRuc(ruc)
                    .map(existing -> {
                        CompanyMapper.updateEntity(existing, dto);
                        return companyRepository.save(existing);
                    })
                    .orElseGet(() -> {
                        Company nueva = CompanyMapper.toEntity(dto);
                        return companyRepository.save(nueva);
                    });

            Consulta consulta = new Consulta();
            consulta.setRucConsultado(ruc);
            consulta.setResultado(ResultadoConsulta.SUCCESS);
            consulta.setProviderStatusCode(200);
            consulta.setCompany(company);

            consultaRepository.save(consulta);

            return CompanyMapper.toResponse(company);

        } catch (ProviderException ex) {

            Consulta consulta = new Consulta();
            consulta.setRucConsultado(ruc);
            consulta.setResultado(ResultadoConsulta.ERROR);
            consulta.setMensajeError(ex.getMessage());
            consulta.setProviderStatusCode(ex.getStatus());

            consultaRepository.save(consulta);

            throw ex;

        } catch (FeignException ex) {

            Consulta consulta = new Consulta();
            consulta.setRucConsultado(ruc);
            consulta.setResultado(ResultadoConsulta.ERROR);
            consulta.setMensajeError(ex.getMessage());
            consulta.setProviderStatusCode(ex.status());

            consultaRepository.save(consulta);

            throw new ProviderException("Error proveedor SUNAT", ex.status());
        }
    }

    public List<ConsultaResponse> historial(String ruc) {
        return consultaRepository
                .findByRucConsultadoOrderByCreatedAtDesc(ruc)
                .stream()
                .map(ConsultaMapper::toResponse)
                .toList();
    }
}