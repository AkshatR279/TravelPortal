package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.destination.DestinationUpdateRequest;
import com.akshatr.travelportal.model.entity.Destination;
import com.akshatr.travelportal.repository.DestinationRepository;
import com.akshatr.travelportal.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;

    @Override
    public Destination update(DestinationUpdateRequest request) {
        Destination destination = new Destination();
        if("U".equals(request.getAction())){
            destination = destinationRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Destination not found for the provided UUID."));
        }
        else{
            destination.setUuid(UUID.randomUUID());
            destination.setActive(true);
        }

        destination.setName(request.getName());
        destination.setCode(request.getCode());

        return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> listDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination get(String uuid) {
        return destinationRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Destination not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Destination company = destinationRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Destination not found for the provided UUID."));

        destinationRepository.delete(company);
    }
}
