package com.pugliatti.andrea.retrofocus.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pugliatti.andrea.retrofocus.model.User;
import com.pugliatti.andrea.retrofocus.repository.UserRepository;

@Service
public class DbUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    public DbUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if (userAttempt.isEmpty()) {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
        return new DbUserDetails(userAttempt.get());
    }
}
