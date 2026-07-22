package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    public Optional<Destination> findByUuid(UUID uuid);
}
