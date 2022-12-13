package com.dronecommunication.controller;

import com.dronecommunication.model.Drone;
import com.dronecommunication.model.Medication;
import com.dronecommunication.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/register")
    public void registerDrone(@RequestBody Drone drone) {
        droneService.registerDrone(drone);
    }

    // Endpoint for loading a drone with medication items
    @PostMapping("/load")
    public void loadDrone(@RequestBody Drone request, List<Medication> medication) {
        // Retrieve the drone from the repository
        droneService.loadDrone(request, medication);
        // Update the drone's state to LOADED
        droneService.droneSetState(request, Drone.DroneState.LOADED);
        // Save the updated drone to the repository
        droneService.updateDrone(request);
    }

    // Endpoint for checking loaded medication items for a given drone
    @GetMapping("/loaded-medication/{droneId}")
    public  @ResponseBody List<Medication> getLoadedMedication(@PathVariable Long droneId) {
        // Retrieve the drone from the repository
        Optional<Drone> drone = droneService.getDroneById(droneId);

        // Return the list of medication items loaded on the drone
        return drone.get().getMedications();
    }
    @GetMapping("/drone/{ids}")
    public ResponseEntity<List<Drone>> getDronesByIds(@PathVariable List<String> ids) {
        List<Drone> drones = droneService.getByIdIn(ids);
        return ResponseEntity.ok(drones);
    }


    // Endpoint for checking available drones for loading
    @GetMapping("/available-drones")
    public  @ResponseBody List<Drone> getAvailableDrones() {
        // Retrieve all drones from the repository
        List<Drone> drones = droneRepository.findAll();

        // Filter the list of drones to only include drones in the IDLE or RETURNING state
        return drones.stream()
                .filter(d -> d.getState() == DroneState.IDLE || d.getState() == DroneState.RETURNING)
                .collect(Collectors.toList());
    }

    // Endpoint for checking the battery level for a given drone
    @GetMapping("/battery-level/{droneId}")
    public  @ResponseBody int getBatteryLevel(@PathVariable String droneId) {
        // Retrieve the drone from the repository
        Drone drone = droneRepository.findById(droneId);

        // Return the battery level of the drone
        return drone.getBatteryLevel();
    }

}

}
