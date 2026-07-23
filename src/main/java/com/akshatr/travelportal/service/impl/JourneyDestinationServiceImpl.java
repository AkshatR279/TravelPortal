package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.journey.JourneyUpdateRequest;
import com.akshatr.travelportal.model.entity.Company;
import com.akshatr.travelportal.model.entity.Journey;
import com.akshatr.travelportal.repository.CompanyRepository;
import com.akshatr.travelportal.repository.JourneyDestinationRepository;
import com.akshatr.travelportal.repository.JourneyRepository;
import com.akshatr.travelportal.service.JourneyDestinationService;
import com.akshatr.travelportal.service.JourneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JourneyDestinationServiceImpl implements JourneyDestinationService {
    private final JourneyDestinationRepository journeyDestinationRepository;
    private final JourneyRepository journeyRepository;

    @Override
    public Journey update(JourneyUpdateRequest request) {
        Company company = companyRepository.findByUuid(UUID.fromString(request.getCompanyUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Company not found for the provided UUID."));

        Journey journey = new Journey();
        if("U".equals(request.getAction())){
            journey = journeyRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Journey not found for the provided UUID."));
        }
        else{
            journey.setUuid(UUID.randomUUID());
            journey.setActive(true);
        }

        journey.setName(request.getName());
        journey.setCode(request.getCode());
        journey.setCompany(company);

        return journeyRepository.save(journey);
    }

    @Override
    public List<Journey> listJourneys() {
        return journeyRepository.findAll();
    }

    @Override
    public Journey get(String uuid) {
        return journeyRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Journey not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Journey journey = journeyRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Journey not found for the provided UUID."));

        journeyRepository.delete(journey);
    }
}
