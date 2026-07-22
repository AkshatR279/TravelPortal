package com.akshatr.travelportal.model.dto.user;

import com.akshatr.travelportal.model.entity.LoginDetails;
import com.akshatr.travelportal.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private UserDetails user;
    private UserLoginDetails login;

    public LoginResponse(User user, LoginDetails loginDetails){
        this.user = new UserDetails(user);
        this.login = new UserLoginDetails(loginDetails);
    }
}
