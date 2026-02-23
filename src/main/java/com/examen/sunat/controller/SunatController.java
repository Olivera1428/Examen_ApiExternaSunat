package com.examen.sunat.controller;

import com.examen.sunat.dto.BaseResponse;
import com.examen.sunat.dto.CompanyResponse;
import com.examen.sunat.dto.ConsultaResponse;
import com.examen.sunat.service.SunatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sunat/ruc")
public class SunatController {

    private final SunatService service;

    public SunatController(SunatService service) {
        this.service = service;
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<BaseResponse<CompanyResponse>> consultar(@PathVariable String ruc) {

        CompanyResponse response = service.consultarRuc(ruc);

        return ResponseEntity.ok(
                new BaseResponse<>(
                        200,
                        "Consulta SUNAT exitosa",
                        response
                )
        );
    }

    @GetMapping("/{ruc}/consultas")
    public ResponseEntity<BaseResponse<List<ConsultaResponse>>> historial(@PathVariable String ruc) {

        List<ConsultaResponse> response = service.historial(ruc);

        return ResponseEntity.ok(
                new BaseResponse<>(
                        200,
                        "Historial obtenido correctamente",
                        response
                )
        );
    }
}