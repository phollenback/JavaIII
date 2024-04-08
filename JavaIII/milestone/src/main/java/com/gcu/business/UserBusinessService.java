package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

@Service
public class UserBusinessService implements UserDetailsService {

    private final UsersDataService service;

    @Autowired
    public UserBusinessService(UsersDataService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = service.findByUsername(username);

        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            // Add any necessary roles or authorities based on your application logic
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}

