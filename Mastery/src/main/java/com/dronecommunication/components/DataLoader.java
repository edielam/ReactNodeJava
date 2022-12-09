package com.dronecommunication.components;

import com.dronecommunication.model.Drone;
import com.dronecommunication.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private DroneRepository droneRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create a list of drones to preload
        List<Drone> drones = Arrays.asList(
                new Drone("123", "Lightweight", 100, 75, Drone.DroneState.IDLE),
                new Drone("456", "Middleweight", 200, 50, Drone.DroneState.IDLE),
                new Drone("789", "Cruiserweight", 300, 25, Drone.DroneState.IDLE)
        );

        // Save the drones to the database
        droneRepository.saveAll(drones);
    }

}