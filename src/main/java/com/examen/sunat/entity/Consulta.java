package com.examen.sunat.entity;

import com.examen.sunat.enums.ResultadoConsulta;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rucConsultado;

    @Enumerated(EnumType.STRING)
    private ResultadoConsulta resultado;

    private String mensajeError;
    private Integer providerStatusCode;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @ManyToOne(optional = true)
    @JoinColumn(name = "company_id")
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRucConsultado() {
        return rucConsultado;
    }

    public void setRucConsultado(String rucConsultado) {
        this.rucConsultado = rucConsultado;
    }

    public ResultadoConsulta getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoConsulta resultado) {
        this.resultado = resultado;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Integer getProviderStatusCode() {
        return providerStatusCode;
    }

    public void setProviderStatusCode(Integer providerStatusCode) {
        this.providerStatusCode = providerStatusCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}