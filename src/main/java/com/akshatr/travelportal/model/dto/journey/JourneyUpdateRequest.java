package com.akshatr.travelportal.model.dto.journey;

import lombok.Getter;

@Getter
public class JourneyUpdateRequest {
    private String action;
    private String uuid;
    private String code;
    private String name;
    private String companyUuid;
}
