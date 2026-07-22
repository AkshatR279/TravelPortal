package com.akshatr.travelportal.model.dto.company;

import lombok.Getter;

@Getter
public class CompanyUpdateRequest {
    private String action;
    private String uuid;
    private String name;
}
