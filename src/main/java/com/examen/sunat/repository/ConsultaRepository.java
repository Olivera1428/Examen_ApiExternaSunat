package com.examen.sunat.repository;

import com.examen.sunat.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    List<Consulta> findByRucConsultadoOrderByCreatedAtDesc(String ruc);
}
