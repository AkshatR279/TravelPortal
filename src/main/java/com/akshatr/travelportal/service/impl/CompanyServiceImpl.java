package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.company.CompanyUpdateRequest;
import com.akshatr.travelportal.model.entity.Company;
import com.akshatr.travelportal.repository.CompanyRepository;
import com.akshatr.travelportal.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Company update(CompanyUpdateRequest request) {
        Company company = new Company();
        if("U".equals(request.getAction())){
            company = companyRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Company not found for the provided UUID."));
        }
        else{
            company.setUuid(UUID.randomUUID());
            company.setActive(true);
        }

        company.setName(request.getName());

        return companyRepository.save(company);
    }

    @Override
    public List<Company> listCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company get(String uuid) {
        return companyRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Company not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Company company = companyRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Company not found for the provided UUID."));

        companyRepository.delete(company);
    }
}
