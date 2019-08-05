package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping("api/v1/")

public class TrackController {

    private TrackService trackService;
    public TrackController() {
    }
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Sucessfully Saved", HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById(id);
            responseEntity = new ResponseEntity(trackService.getTrackById(id), HttpStatus.OK);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("deletetrack/{id}")
    public ResponseEntity<?> getDeleteTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try{
            trackService.getDeleteTrackById(id);
            responseEntity = new ResponseEntity("Sucessfully Deleted", HttpStatus.OK);
        }catch (TrackNotFoundException ex){
            responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try {
            trackService.getAllTracks();
            responseEntity = new ResponseEntity(trackService.getAllTracks(),HttpStatus.OK);
        }catch (Exception ex){
            responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            ex.printStackTrace();
        }
        return responseEntity;
    }
    //Mapping using method getTrackByName
    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable String str){
        List<Track> trackByName = trackService.getTrackByName(str);
                return new ResponseEntity<>(trackByName, HttpStatus.OK);
    }
    @PatchMapping("track/{name}")
    public ResponseEntity<?> getupdateById(@PathVariable String name, @RequestBody String comment)
    {
        Track updatedTrack = trackService.getUpdateByName(name, comment);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
}


