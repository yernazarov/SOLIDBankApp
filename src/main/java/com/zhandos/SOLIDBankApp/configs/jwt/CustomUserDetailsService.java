package com.zhandos.SOLIDBankApp.configs.jwt;

import com.zhandos.SOLIDBankApp.entities.User;
import com.zhandos.SOLIDBankApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Lazy
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}