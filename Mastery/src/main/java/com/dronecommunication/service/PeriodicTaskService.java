package com.dronecommunication.service;

import java.util.List;

import com.dronecommunication.model.Drone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PeriodicTaskService {

    private static final Logger LOG = LoggerFactory.getLogger(PeriodicTaskService.class);

    private final DroneService droneService;

    public PeriodicTaskService(DroneService droneService) {
        this.droneService = droneService;
    }

    @Scheduled(cron = "${app.battery-check-task.cron}")
    public void checkBatteryLevels() {
        List<Drone> drones = droneService.getAllDrones();
        for (Drone drone : drones) {
            int batteryLevel = drone.getBatteryCapacity();
            LOG.info("Battery level for drone {}: {}%", drone.getSerialNumber(), batteryLevel);
        }
    }
}
// In this implementation, the PeriodicTaskService class has a
// checkBatteryLevels method that is annotated with @Scheduled to
//  indicate that it should be executed periodically according to the
//  schedule defined in the application.properties file. The method
//  uses the DroneService to retrieve a list of all the drones, and
//  then iterates over the list to log the battery level for each drone.
