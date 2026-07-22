package com.akshatr.travelportal.exception;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException(String message){
        super(message);
    }
}
