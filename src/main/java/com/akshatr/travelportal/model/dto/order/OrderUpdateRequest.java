package com.akshatr.travelportal.model.dto.order;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderUpdateRequest {
    private String action;
    private String uuid;
    private String code;
    private String name;
    private String userUuid;
}
