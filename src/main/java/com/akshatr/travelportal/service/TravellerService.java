package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.traveller.TravellerUpdateRequest;
import com.akshatr.travelportal.model.entity.Traveller;

import java.util.List;

public interface TravellerService {
    public Traveller update(TravellerUpdateRequest request);
    public List<Traveller> listTravellers();
    public Traveller get(String uuid);
    public void delete(String uuid);
}
