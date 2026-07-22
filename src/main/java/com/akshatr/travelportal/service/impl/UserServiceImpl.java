package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.user.UserUpdateRequest;
import com.akshatr.travelportal.model.entity.User;
import com.akshatr.travelportal.repository.UserRepository;
import com.akshatr.travelportal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User update(UserUpdateRequest request){
        User user = new User();
        if("U".equals(request.getAction())){
            user = userRepository.findByUuid(UUID.fromString(request.getUuid()))
                    .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));
        }
        else{
            user.setUsername(request.getUsername());
            user.setUuid(UUID.randomUUID());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setActive(true);
        }

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());

        return userRepository.save(user);
    }

    @Override
    public User get(String uuid) {
        return userRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(String uuid) {
        User user = userRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));

        userRepository.delete(user);
    }
}
