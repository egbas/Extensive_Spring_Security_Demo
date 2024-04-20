package com.egbas.demospringsecurity.service;

import com.egbas.demospringsecurity.payload.request.AuthenticateRequest;
import com.egbas.demospringsecurity.payload.request.RegisterRequest;
import com.egbas.demospringsecurity.payload.response.AuthenticationResponse;

public interface AuthService {

    public AuthenticationResponse Register(RegisterRequest registerRequest);

    public AuthenticationResponse login(AuthenticateRequest authenticateRequest);
}
