package com.stackroute.exception;
//This exception will check if any Track is already not present for which we are searching
public class TrackNotFoundException extends Exception{
    public String message;
    public TrackNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
