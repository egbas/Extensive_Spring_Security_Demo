package com.egbas.demospringsecurity.infrastructure.exceptions;

public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String message){
        super(message);
    }
}
