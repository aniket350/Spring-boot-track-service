package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("trackServiceImpl")
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track in TrackServiceImplementation already exits");
        }
        if (track == null) {
                throw new TrackAlreadyExistsException("Given null value");
            }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)) {
                throw new TrackNotFoundException("Track is not present");
        }
        Track retrievedTrack = trackRepository.findById(id).get();
        return retrievedTrack;
    }

    @Override
    public Track getDeleteTrackById(int id) throws TrackNotFoundException {
        if (!trackRepository.existsById(id)){
            throw new TrackNotFoundException("Track is not present");
        }
        Track deletedTrack = trackRepository.findById(id).get();
        trackRepository.deleteById(id);
        return deletedTrack;
        }


        @Override
        public List<Track> getTrackByName (String str){
            List<Track> trackByName = trackRepository.getByName(str);
            return (List<Track>) trackByName;
        }
        @Override
        public Track getUpdateByName (String name, String comment){
            Track updatedTrack = trackRepository.getUpdateByName(name, comment);
            return updatedTrack;
        }

        @Override
        public List<Track> getAllTracks() {

            return trackRepository.findAll();
        }
}
