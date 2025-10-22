package com.example.EventManagement.controller;

import com.example.EventManagement.entity.User;
import com.example.EventManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        Map<String, String> response = userService.registerUser(user);

        if ("success".equals(response.get("status"))){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
