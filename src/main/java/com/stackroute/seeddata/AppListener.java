package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
//Implementing using  AppListener
@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {

//    Track track;
    TrackRepository trackRepository;

    public AppListener() {
    }

    @Autowired
    public AppListener( TrackRepository trackRepository) {
//        this.track = track;
        this.trackRepository = trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track = new Track(10,"hagc","shcwihdi");
        trackRepository.save(track);
    }
}
