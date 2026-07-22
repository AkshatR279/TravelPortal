package com.akshatr.travelportal.model.dto.destination;

import com.akshatr.travelportal.model.entity.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDetails {
    private UUID uuid;
    private String name;
    private Boolean active;

    public DestinationDetails(Destination destination){
        this.uuid = destination.getUuid();
        this.name = destination.getName();
        this.active = destination.getActive();
    }
}
