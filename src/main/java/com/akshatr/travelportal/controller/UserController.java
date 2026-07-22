package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.user.UserDetails;
import com.akshatr.travelportal.model.dto.user.UserUpdateRequest;
import com.akshatr.travelportal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public UserDetails save(@RequestBody UserUpdateRequest request){
        return new UserDetails(userService.update(request));
    }

    @GetMapping("/{uuid}")
    public UserDetails get(@PathVariable String uuid){
        return new UserDetails(userService.get(uuid));
    }

    @PostMapping("/search")
    public List<UserDetails> listUsers(){
        return userService.listUsers().stream()
                .map(UserDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        userService.delete(uuid);
    }
}
