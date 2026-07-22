package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.exception.UnauthenticatedException;
import com.akshatr.travelportal.model.dto.user.LoginRequest;
import com.akshatr.travelportal.model.dto.user.LoginResponse;
import com.akshatr.travelportal.model.dto.user.UserLoginDetails;
import com.akshatr.travelportal.model.entity.LoginDetails;
import com.akshatr.travelportal.model.entity.User;
import com.akshatr.travelportal.repository.LoginDetailsRepository;
import com.akshatr.travelportal.repository.UserRepository;
import com.akshatr.travelportal.service.LoginService;
import com.akshatr.travelportal.utility.jwt.TokenUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final LoginDetailsRepository loginDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenUtility tokenUtility;

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("No active user found with the provided username."));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new UnauthenticatedException("Invalid password.");
        }

        logoutPreviousLogins(user);
        LoginDetails loginDetails = registerNewLogin(user, tokenUtility.generateToken(user));

        return new LoginResponse(user, loginDetails);
    }

    public void logoutPreviousLogins(User user){
        Optional<LoginDetails> loginDetails = loginDetailsRepository.findActiveLoginByUser(user);
        if(loginDetails.isPresent()){
            loginDetails.get().setLogoutDate(new Timestamp(System.currentTimeMillis()));
            loginDetails.get().setLoggedIn(false);
        }
    }

    public LoginDetails registerNewLogin(User user, UserLoginDetails userLoginDetails){
        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setUser(user);
        loginDetails.setLoggedIn(true);
        loginDetails.setLoginDate(userLoginDetails.getLoginTime());
        loginDetails.setToken(userLoginDetails.getToken());
        loginDetails.setExpiryTime(userLoginDetails.getExpiryTime());
        return loginDetailsRepository.save(loginDetails);
    }
}
