package com.akshatr.travelportal.model.dto.journeyDestination;

import com.akshatr.travelportal.model.dto.destination.DestinationDetails;
import com.akshatr.travelportal.model.entity.JourneyDestination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDestinationDetails {
    private UUID uuid;
    private String name;
    private Boolean active;
    private Integer sequence;
    private DestinationDetails destination;

    public JourneyDestinationDetails(JourneyDestination journeyDestination){
        this.uuid = journeyDestination.getUuid();
        this.name = journeyDestination.getName();
        this.active = journeyDestination.getActive();
        this.sequence = journeyDestination.getSequence();
        this.destination = new DestinationDetails(journeyDestination.getDestination());
    }
}
