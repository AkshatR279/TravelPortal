package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.destination.DestinationUpdateRequest;
import com.akshatr.travelportal.model.entity.Destination;
import java.util.List;

public interface DestinationService {
    public Destination update(DestinationUpdateRequest request);
    public Destination get(String uuid);
    public List<Destination> listDestinations();
    public void delete(String uuid);
}
