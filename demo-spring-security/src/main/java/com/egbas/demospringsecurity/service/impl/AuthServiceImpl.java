package com.egbas.demospringsecurity.service.impl;

import com.egbas.demospringsecurity.domain.entities.User;
import com.egbas.demospringsecurity.infrastructure.config.JwtService;
import com.egbas.demospringsecurity.payload.request.AuthenticateRequest;
import com.egbas.demospringsecurity.payload.request.RegisterRequest;
import com.egbas.demospringsecurity.payload.response.AuthenticationResponse;
import com.egbas.demospringsecurity.repository.UserRepository;
import com.egbas.demospringsecurity.service.AuthService;
import com.egbas.demospringsecurity.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
//    private final AuthUtils authUtils;
    @Override
    public AuthenticationResponse Register(RegisterRequest registerRequest) {

        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
//                .password(registerRequest.getPassword()) this is bad practice passwords should always be saved as encrypted
                .password(passwordEncoder.encode(registerRequest.getPassword())) // This is used to encrypt the password using the password encoder bean
                .role(registerRequest.getRole())
                .build();

        User savedUser = userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

//Depending on the situation you can return only the access token
        return AuthenticationResponse.builder()
                .responseCode(AuthUtils.ACCOUNT_CREATION_CODE)
                .responseMessage(AuthUtils.ACCOUNT_CREATION_SUCCESS_MESSAGE)
                .email(savedUser.getEmail())
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(AuthenticateRequest authenticateRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(), authenticateRequest.getPassword())
        );

        User user = userRepository.findByEmail(authenticateRequest.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .responseCode(AuthUtils.LOGIN_SUCCESS_CODE)
                .responseMessage(AuthUtils.LOGIN_SUCCESS_MESSAGE)
                .accessToken(jwtToken)
                .build();
    }
}
