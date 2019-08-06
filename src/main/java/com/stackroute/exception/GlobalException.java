package com.stackroute.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//Handling all global exception
public class GlobalException {

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> trackNotFoundEXception(final TrackNotFoundException te) {
        return new ResponseEntity<>(te.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<?> trackNotFoundEXception(final TrackAlreadyExistsException te) {
        return new ResponseEntity<>(te.getMessage(), HttpStatus.CONFLICT);
    }
}