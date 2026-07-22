package com.akshatr.travelportal.model.dto.journey;

import com.akshatr.travelportal.model.dto.company.CompanyDetails;
import com.akshatr.travelportal.model.entity.Journey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDetails {
    private UUID uuid;
    private String name;
    private Boolean active;
    private CompanyDetails company;

    public JourneyDetails(Journey journey){
        this.uuid = journey.getUuid();
        this.name = journey.getName();
        this.active = journey.getActive();
        this.company = new CompanyDetails(journey.getCompany());
    }
}
