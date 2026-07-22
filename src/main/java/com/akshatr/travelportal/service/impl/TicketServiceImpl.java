package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.company.CompanyUpdateRequest;
import com.akshatr.travelportal.model.dto.ticket.TicketUpdateRequest;
import com.akshatr.travelportal.model.entity.*;
import com.akshatr.travelportal.repository.*;
import com.akshatr.travelportal.service.CompanyService;
import com.akshatr.travelportal.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final JourneyRepository journeyRepository;
    private final TravellerRepository travellerRepository;

    @Override
    public Ticket update(TicketUpdateRequest request) {
        User user = userRepository.findByUuid(UUID.fromString(request.getUserUuid()))
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));

        Journey journey = journeyRepository.findByUuid(UUID.fromString(request.getJourneyUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Journey not found for the provided UUID."));

        List<Traveller> travellers = new ArrayList<>();
        for(String traveller : request.getTravellers()){
            travellers.add(travellerRepository.findByUuid(UUID.fromString(traveller))
                    .orElseThrow(() -> new EntityNotFoundException("Traveller not found for the provided UUID. [UUID:" + traveller + "]")));
        }

        Ticket ticket = new Ticket();
        if("U".equals(request.getAction())){
            ticket = ticketRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found for the provided UUID."));
        }
        else{
            ticket.setUuid(UUID.randomUUID());
            ticket.setActive(true);
            ticket.setUser(user);
            ticket.setJourney(journey);
        }

        ticket.setName(request.getName());
        ticket.setCode(request.getCode());
        ticket.setTravellers(travellers);

        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket get(String uuid) {
        return ticketRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Ticket ticket = ticketRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found for the provided UUID."));

        ticketRepository.delete(ticket);
    }
}
