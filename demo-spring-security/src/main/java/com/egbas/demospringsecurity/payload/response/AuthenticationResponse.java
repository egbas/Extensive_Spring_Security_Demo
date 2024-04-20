package com.egbas.demospringsecurity.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {

    private String responseCode;
    private String responseMessage;
    private String email;

    @JsonProperty("access_token")
    private String accessToken;
}
