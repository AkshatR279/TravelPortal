package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.user.LoginRequest;
import com.akshatr.travelportal.model.dto.user.LoginResponse;
import com.akshatr.travelportal.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/user")
    public LoginResponse login(@RequestBody LoginRequest request){
        return loginService.login(request);
    }
}
