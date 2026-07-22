package com.akshatr.travelportal.model.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateRequest {
    private String action;
    private String uuid;
    private String username;
    private String password;
    private String name;
    private String mobile;
    private String email;
}
