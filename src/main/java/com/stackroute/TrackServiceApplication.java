package com.stackroute;
import com.stackroute.service.TrackService;
import org.jboss.logging.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//PropertySource is used to tell main file to start with particular mentioned files
@PropertySource("application-prod.properties")
public class TrackServiceApplication {

    public static void main(String[] args) { SpringApplication.run(TrackServiceApplication.class, args);
    }
}

