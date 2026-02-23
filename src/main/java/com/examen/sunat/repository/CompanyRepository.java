package com.examen.sunat.repository;

import com.examen.sunat.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository <Company,Long> {
    Optional<Company> findByRuc(String ruc);

}
