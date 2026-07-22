package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.user.LoginRequest;
import com.akshatr.travelportal.model.dto.user.LoginResponse;

public interface LoginService {
    public LoginResponse login(LoginRequest request);
}
