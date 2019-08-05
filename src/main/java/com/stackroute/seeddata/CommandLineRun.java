package com.stackroute.seeddata;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRun implements CommandLineRunner {

//    Track track;
    TrackRepository trackRepository;

    @Autowired
    public CommandLineRun( TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public CommandLineRun() {
    }

    @Override
    public void run(String... args) throws Exception {
        Track track = new Track(15,"aniket","saregamapa");
        trackRepository.save(track);
    }
}