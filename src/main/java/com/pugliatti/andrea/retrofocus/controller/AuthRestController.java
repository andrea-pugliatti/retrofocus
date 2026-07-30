package com.pugliatti.andrea.retrofocus.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pugliatti.andrea.retrofocus.dto.AuthResponseDTO;
import com.pugliatti.andrea.retrofocus.dto.LoginRequestDTO;
import com.pugliatti.andrea.retrofocus.service.JwtService;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthRestController {

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    public AuthRestController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO requestBody) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestBody.getUsername(), requestBody.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String response = jwtService.generateToken(userDetails);

        return new AuthResponseDTO(response);
    }

}
