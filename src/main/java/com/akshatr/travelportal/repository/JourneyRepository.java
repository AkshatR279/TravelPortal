package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
    public Optional<Journey> findByUuid(UUID uuid);
}
