package com.akshatr.travelportal.model.dto.user;

import com.akshatr.travelportal.model.entity.LoginDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDetails {
    private String token;
    private Timestamp loginTime;
    private Timestamp expiryTime;

    public UserLoginDetails(LoginDetails loginDetails) {
        this.token = loginDetails.getToken();
        this.loginTime = loginDetails.getLoginDate();
        this.expiryTime = loginDetails.getExpiryTime();
    }
}
