package com.stackroute.exception;

public class TrackExceptions extends Exception{

    private String message;

    public  TrackExceptions() {}
    public  TrackExceptions(String message) { super(message);this.message=message; }



}