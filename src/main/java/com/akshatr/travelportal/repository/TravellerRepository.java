package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TravellerRepository extends JpaRepository<Traveller, Long> {
    public Optional<Traveller> findByUuid(UUID uuid);
}
