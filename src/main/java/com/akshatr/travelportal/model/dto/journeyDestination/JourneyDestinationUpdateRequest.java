package com.akshatr.travelportal.model.dto.journeyDestination;

import lombok.Getter;

@Getter
public class JourneyDestinationUpdateRequest {
    private String action;
    private String uuid;
    private String name;
    private Integer sequence;
    private String journeyUuid;
    private String destinationUuid;
}
