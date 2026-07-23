package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.journeyDestination.JourneyDestinationUpdateRequest;
import com.akshatr.travelportal.model.entity.JourneyDestination;

import java.util.List;

public interface JourneyDestinationService {
    public JourneyDestination update(JourneyDestinationUpdateRequest request);
    public JourneyDestination get(String uuid);
    public List<JourneyDestination> listJourneys();
    public void delete(String uuid);
}
