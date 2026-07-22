package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Optional<Company> findByUuid(UUID uuid);
}
