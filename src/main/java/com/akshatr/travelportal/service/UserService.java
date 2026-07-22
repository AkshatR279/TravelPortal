package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.user.UserUpdateRequest;
import com.akshatr.travelportal.model.entity.User;

import java.util.List;

public interface UserService {
    public User update(UserUpdateRequest request);
    public User get(String uuid);
    public List<User> listUsers();
    public void delete(String uuid);
}
