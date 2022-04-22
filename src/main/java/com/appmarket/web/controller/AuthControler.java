package com.appmarket.web.controller;


import com.appmarket.domain.dto.AutenticationRequest;
import com.appmarket.domain.dto.AutenticationResponse;
import com.appmarket.domain.service.UserDetailsService;
import com.appmarket.web.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.BadAttributeValueExpException;

@RestController
@RequestMapping("/auth")
public class AuthControler {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    JWTUtil jwtUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<AutenticationResponse> createToken(@RequestBody AutenticationRequest request){

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AutenticationResponse(jwt), HttpStatus.OK);
        }catch (BadCredentialsException badCredentialsException){

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        }


    }



}
