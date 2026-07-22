package com.akshatr.travelportal.model.dto.user;

import com.akshatr.travelportal.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private UUID uuid;
    private String username;
    private String name;
    private String mobile;
    private String email;
    private Boolean active;

    public UserDetails(User user){
        this.uuid = user.getUuid();
        this.username = user.getUsername();
        this.name = user.getName();
        this.mobile = user.getMobile();
        this.email = user.getEmail();
        this.active = user.getActive();
    }
}
