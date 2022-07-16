package com.zhandos.SOLIDBankApp.controllers;

import com.zhandos.SOLIDBankApp.configs.jwt.JwtProvider;
import com.zhandos.SOLIDBankApp.dto.SignUpRequest;
import com.zhandos.SOLIDBankApp.dto.UserRequest;
import com.zhandos.SOLIDBankApp.entities.User;
import com.zhandos.SOLIDBankApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid SignUpRequest signUpRequest) {
        Map<String, Object> responseMessage = new HashMap<>();
        User u = new User();
        u.setPassword(signUpRequest.getPassword());
        u.setUsername(signUpRequest.getUsername());
        try {
            userService.saveUser(u);
            responseMessage.put("message", "User successfully registered");
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            responseMessage.put("Error", "This user already exists");
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody UserRequest request) {
        Map<String, Object> responseMessage = new HashMap<>();
        try {
            User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
            String token = jwtProvider.generateToken(user.getUsername());
            responseMessage.put("token", token);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            responseMessage.put("Error", "There is no such user");
            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
        }
    }
}