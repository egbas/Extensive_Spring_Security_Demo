package com.egbas.demospringsecurity.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorRequest {

    private String message;
    private String debugMessage;
    private LocalDateTime errorTime;
}
