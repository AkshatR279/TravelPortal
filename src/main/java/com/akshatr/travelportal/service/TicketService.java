package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.ticket.TicketUpdateRequest;
import com.akshatr.travelportal.model.entity.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket update(TicketUpdateRequest request);
    public List<Ticket> listTickets();
    public Ticket get(String uuid);
    public void delete(String uuid);
}
