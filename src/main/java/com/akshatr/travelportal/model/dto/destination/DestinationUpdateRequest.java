package com.akshatr.travelportal.model.dto.destination;

import lombok.Getter;

@Getter
public class DestinationUpdateRequest {
    private String action;
    private String uuid;
    private String code;
    private String name;
}
