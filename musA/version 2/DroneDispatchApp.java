package version 2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroneDispatchApp {

    public static void main(String[] args) {
        SpringApplication.run(DroneCommunicationApp.class, args);
    }
}
