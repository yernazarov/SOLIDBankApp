package com.zhandos.SOLIDBankApp.jwt;

import com.zhandos.SOLIDBankApp.user.User;
import com.zhandos.SOLIDBankApp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service // 1
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository; // 2

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user " + user + " is not found");
        }
        return new CustomUserDetails(user);
    }

    static final class CustomUserDetails extends User implements UserDetails {
        private static final List<GrantedAuthority> ROLE_USER = Collections
                .unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER")); // Создаем роль

        CustomUserDetails(User user) {
            super(user.getUserID(), user.getUsername(), user.getPassword());
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return ROLE_USER;
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
}