package com.zhandos.SOLIDBankApp.user;

import com.zhandos.SOLIDBankApp.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid SignUpRequest signUpRequest) {
        User u = new User();
        u.setPassword(signUpRequest.getPassword());
        u.setUsername(signUpRequest.getUsername());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping("/auth")
    public UserResponse auth(@RequestBody UserRequest request) {
        User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(user.getUsername());
        return new UserResponse(token);
    }
}