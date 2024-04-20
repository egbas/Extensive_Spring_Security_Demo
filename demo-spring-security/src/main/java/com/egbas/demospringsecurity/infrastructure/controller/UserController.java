package com.egbas.demospringsecurity.infrastructure.controller;

import com.egbas.demospringsecurity.payload.request.AuthenticateRequest;
import com.egbas.demospringsecurity.payload.request.RegisterRequest;
import com.egbas.demospringsecurity.payload.response.AuthenticationResponse;
import com.egbas.demospringsecurity.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){

        AuthenticationResponse authResponse = authService.Register(registerRequest);

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticateRequest authenticateRequest){
        AuthenticationResponse authResponse = authService.login(authenticateRequest);

        return ResponseEntity.ok(authResponse);
    }
}
