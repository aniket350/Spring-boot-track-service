package com.stackroute.exception;
//This Exception will check if any Track already present then it will return Exception
public class TrackAlreadyExistsException extends Exception {
    public String message;
    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message=message;
    }
}