package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.journey.JourneyUpdateRequest;
import com.akshatr.travelportal.model.entity.Journey;
import java.util.List;

public interface JourneyService {
    public Journey update(JourneyUpdateRequest request);
    public Journey get(String uuid);
    public List<Journey> listJourneys();
    public void delete(String uuid);
}
