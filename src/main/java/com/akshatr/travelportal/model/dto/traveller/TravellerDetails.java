package com.akshatr.travelportal.model.dto.traveller;

import com.akshatr.travelportal.model.entity.Traveller;
import com.akshatr.travelportal.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravellerDetails {
    private UUID uuid;
    private String name;
    private int age;
    private Gender gender;
    private Boolean active;

    public TravellerDetails(Traveller traveller){
        this.uuid = traveller.getUuid();
        this.name = traveller.getName();
        this.age = traveller.getAge();
        this.gender = traveller.getGender();
        this.active = traveller.getActive();
    }
}
