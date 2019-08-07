//package com.stackroute.service;
//
//import com.stackroute.domain.Track;
//import com.stackroute.exception.TrackAlreadyExistsException;
//import com.stackroute.exception.TrackNotFoundException;
//import com.stackroute.repository.TrackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Profile;
//
//import java.util.List;
//@Profile("dummy")
//public class TrackDummyServiceImpl implements TrackService {
//    private TrackRepository trackRepository;
//    @Autowired
//    public TrackDummyServiceImpl(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
//        if (trackRepository.existsById(track.getId())) {
//            throw new TrackAlreadyExistsException("Track in TrackServicedummyImplementation already exits");
//        }
//        if (track == null) {
//            throw new TrackAlreadyExistsException("Given null value");
//        }
//        Track savedTrack = trackRepository.save(track);
//        return savedTrack;
//    }
//
//    @Override
//    public Track getTrackById(int id) throws TrackNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Track getDeleteTrackById(int id) throws TrackNotFoundException {
//        return null;
//    }
//
//    @Override
//    public List<Track> getTrackByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Track getUpdateByName(String name, String comment) {
//        return null;
//    }
//
//    @Override
//    public List<Track> getAllTracks() {
//        return null;
//    }
//}
