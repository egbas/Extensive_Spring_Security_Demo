package com.egbas.demospringsecurity.payload.request;


import com.egbas.demospringsecurity.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
