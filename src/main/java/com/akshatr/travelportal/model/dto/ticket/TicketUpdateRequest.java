package com.akshatr.travelportal.model.dto.ticket;

import lombok.Getter;

import java.util.List;

@Getter
public class TicketUpdateRequest {
    private String action;
    private String uuid;
    private String code;
    private String name;
    private String journeyUuid;
    private String userUuid;
    private List<String> travellers;
}
