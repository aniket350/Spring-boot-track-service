package com.stackroute.exception;

public class TrackAlreadyExistsException extends Exception {
    public String message;
    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message=message;
    }
}