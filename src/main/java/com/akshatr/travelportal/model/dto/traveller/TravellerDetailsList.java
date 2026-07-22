package com.akshatr.travelportal.model.dto.traveller;

import com.akshatr.travelportal.model.entity.Traveller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravellerDetailsList {
    private int count;
    private List<TravellerDetails> travellerList;

    public TravellerDetailsList(List<Traveller> travellers){
        this.count = travellers.size();
        this.travellerList = travellers.stream()
                .map(TravellerDetails::new)
                .toList();
    }
}
