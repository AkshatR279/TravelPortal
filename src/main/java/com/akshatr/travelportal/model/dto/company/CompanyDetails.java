package com.akshatr.travelportal.model.dto.company;

import com.akshatr.travelportal.model.entity.Company;
import com.akshatr.travelportal.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetails {
    private UUID uuid;
    private String name;
    private Boolean active;

    public CompanyDetails(Company company){
        this.uuid = company.getUuid();
        this.name = company.getName();
        this.active = company.getActive();
    }
}
