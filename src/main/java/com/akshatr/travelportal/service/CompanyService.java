package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.company.CompanyUpdateRequest;
import com.akshatr.travelportal.model.entity.Company;

import java.util.List;

public interface CompanyService {
    public Company update(CompanyUpdateRequest request);
    public List<Company> listCompanies();
    public Company get(String uuid);
    public void delete(String uuid);
}
