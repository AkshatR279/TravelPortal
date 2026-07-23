package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Destination;
import com.akshatr.travelportal.model.entity.Journey;
import com.akshatr.travelportal.model.entity.JourneyDestination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JourneyDestinationRepository extends JpaRepository<JourneyDestination, Long> {
    public Optional<JourneyDestination> findByUuid(UUID uuid);
    public List<JourneyDestination> findByJourney(Journey journey);
    public List<JourneyDestination> findByDestination(Destination destination);
}
