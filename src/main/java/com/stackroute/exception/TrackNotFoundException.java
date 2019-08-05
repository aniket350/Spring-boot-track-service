package com.stackroute.exception;

public class TrackNotFoundException extends Exception{
    public String message;
    public TrackNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
