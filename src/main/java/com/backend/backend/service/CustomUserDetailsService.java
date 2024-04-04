package com.backend.backend.service;

import com.backend.backend.entity.Role;
import com.backend.backend.entity.User;
import com.backend.backend.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private AuthRepository  authRepository;

    @Autowired
    public CustomUserDetailsService(AuthRepository  authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRoleToAuthorities(user.getRole()));
    }

    // helper method to get the authorities of a user by converting list to role
    private Collection<GrantedAuthority> mapRoleToAuthorities(List<Role> role) {
        return role.stream().map(roles -> new SimpleGrantedAuthority(roles .getName())).collect(Collectors.toList());
    }
}
