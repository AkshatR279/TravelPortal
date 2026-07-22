package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public Optional<Ticket> findByUuid(UUID uuid);
}
