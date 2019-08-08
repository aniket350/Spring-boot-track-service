package com.stackroute.controller;
import com.stackroute.service.TrackService;
import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

//All CRUD Operations

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;

        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("Sucessfully Saved", HttpStatus.CREATED);
//         catch (TrackAlreadyExistsException ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//            ex.printStackTrace();
//        }
        return responseEntity;
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        trackService.getTrackById(id);
        responseEntity = new ResponseEntity(trackService.getTrackById(id), HttpStatus.OK);

//         catch (TrackNotFoundException ex) {
//            responseEntity = new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
//            ex.printStackTrace();
//        }
        return responseEntity;
    }

    @DeleteMapping("deletetrack/{id}")
    public ResponseEntity<?> getDeleteTrackById(@PathVariable int id) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        trackService.getDeleteTrackById(id);
        responseEntity = new ResponseEntity("Sucessfully Deleted", HttpStatus.CREATED);

//            catch (TrackNotFoundException ex){
//            responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
//            ex.printStackTrace();
//        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        trackService.getAllTracks();
        responseEntity = new ResponseEntity(trackService.getAllTracks(), HttpStatus.OK);
        return responseEntity;
    }
//        catch (Exception ex){
//            responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//            ex.printStackTrace();
//        }

    //Mapping using method getTrackByName
    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getTrackByName (@PathVariable String str){
        ResponseEntity responseEntity1;
        trackService.getTrackByName(str);
        responseEntity1 = new ResponseEntity<>(trackService.getTrackByName(str), HttpStatus.OK);
        return responseEntity1;
    }
    @PatchMapping("track/{name}")
    public ResponseEntity<?> getupdateTrackById (@RequestBody Track track, @PathVariable("id") int id)
    {

        Track updatedTrack = trackService.getUpdateTrackById(track,id);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

}
