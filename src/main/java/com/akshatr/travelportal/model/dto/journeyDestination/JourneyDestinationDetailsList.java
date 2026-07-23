package com.akshatr.travelportal.model.dto.journeyDestination;

import com.akshatr.travelportal.model.entity.JourneyDestination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JourneyDestinationDetailsList {
    private int count;
    private List<JourneyDestinationDetails> journeyDestinations;

    public JourneyDestinationDetailsList(List<JourneyDestination> journeyDestinationList){
        this.count = journeyDestinationList.size();
        this.journeyDestinations = journeyDestinationList.stream()
                .map(JourneyDestinationDetails::new)
                .toList();
    }
}
