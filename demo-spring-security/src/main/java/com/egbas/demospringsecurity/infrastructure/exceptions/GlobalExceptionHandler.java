package com.egbas.demospringsecurity.infrastructure.exceptions;

import com.egbas.demospringsecurity.payload.request.ErrorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFoundException(final UsernameNotFoundException ex){
        ErrorRequest errorRequest = ErrorRequest.builder()
                .message(ex.getMessage())
                .debugMessage("Username Does Not Exist")
                .errorTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorRequest, HttpStatus.NOT_FOUND);
    }
}
