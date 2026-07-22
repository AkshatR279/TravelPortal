package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.company.CompanyUpdateRequest;
import com.akshatr.travelportal.model.dto.traveller.TravellerUpdateRequest;
import com.akshatr.travelportal.model.entity.Company;
import com.akshatr.travelportal.model.entity.Traveller;
import com.akshatr.travelportal.model.entity.User;
import com.akshatr.travelportal.repository.CompanyRepository;
import com.akshatr.travelportal.repository.TravellerRepository;
import com.akshatr.travelportal.repository.UserRepository;
import com.akshatr.travelportal.service.CompanyService;
import com.akshatr.travelportal.service.TravellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TravellerServiceImpl implements TravellerService {
    private final TravellerRepository travellerRepository;
    private final UserRepository userRepository;

    @Override
    public Traveller update(TravellerUpdateRequest request) {
        User user = userRepository.findByUuid(UUID.fromString(request.getUserUuid()))
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));

        Traveller traveller = new Traveller();
        if("U".equals(request.getAction())){
            traveller = travellerRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Traveller not found for the provided UUID."));
        }
        else{
            traveller.setUuid(UUID.randomUUID());
            traveller.setActive(true);
            traveller.setUser(user);
        }

        traveller.setName(request.getName());
        traveller.setAge(request.getAge());
        traveller.setGender(request.getGender());

        return travellerRepository.save(traveller);
    }

    @Override
    public List<Traveller> listTravellers() {
        return travellerRepository.findAll();
    }

    @Override
    public Traveller get(String uuid) {
        return travellerRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Traveller not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Traveller traveller = travellerRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Traveller not found for the provided UUID."));

        travellerRepository.delete(traveller);
    }
}
