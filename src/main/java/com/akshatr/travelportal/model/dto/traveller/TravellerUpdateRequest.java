package com.akshatr.travelportal.model.dto.traveller;

import com.akshatr.travelportal.model.enums.Gender;
import lombok.Getter;

@Getter
public class TravellerUpdateRequest {
    private String action;
    private String uuid;
    private String name;
    private int age;
    private Gender gender;
    private String userUuid;
}
