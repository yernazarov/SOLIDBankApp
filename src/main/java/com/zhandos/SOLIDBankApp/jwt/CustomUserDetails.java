package com.zhandos.SOLIDBankApp.jwt;

import com.zhandos.SOLIDBankApp.role.Role;
import com.zhandos.SOLIDBankApp.role.RoleRepository;
import com.zhandos.SOLIDBankApp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    @Autowired
    private RoleRepository roleRepository;
    public static CustomUserDetails fromUserEntityToCustomUserDetails(User user) {
        CustomUserDetails c = new CustomUserDetails();
        c.username = user.getUsername();
        c.password = user.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")); //hardcoding
        return c;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}