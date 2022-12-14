package com.dronecommunication.controller;

import com.dronecommunication.model.Drone;
import com.dronecommunication.model.Medication;
import com.dronecommunication.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/register")
    public void registerDrone(@RequestBody Drone drone) {
        droneService.registerDrone(drone);
    }
    @GetMapping
    public  @ResponseBody List<Drone> getAllDrones(){
        List<Drone> drones = droneService.getAllDrones();
        return drones;
    }

    // Endpoint for loading a drone with medication items
//    @PostMapping("/load")
//    public void loadDrone(@RequestBody Long id, List<Medication> medication) {
//        // Retrieve the drone from the repository
//        Optional<Drone> drone = droneService.getDroneById(id);
//        droneService.loadDrone(drone, medication);
//        // Update the drone's state to LOADED
//        droneService.droneSetState(drone, Drone.DroneState.LOADED);
//        // Save the updated drone to the repository
//        droneService.updateDrone(drone);
//    }
//    @PostMapping("/{droneId}/medications")
//    public void loadMedications(@PathVariable("droneId") String droneSerialNumber, @RequestBody List<Medication> medications) {
//         droneService.(droneSerialNumber, medications);
//    }
    @PutMapping("/{serialNumber}/medications")
    public ResponseEntity<?> loadMedications(@PathVariable String serialNumber, @RequestBody List<Medication> medications) {
        try {
            droneService.loadMedications(serialNumber, medications);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint for checking loaded medication items for a given drone
    @GetMapping("/loaded-medication/{serialNumber}")
    public  @ResponseBody List<Medication> getLoadedMedication(@PathVariable String serialNumber) {
        // Retrieve the drone from the repository
        Optional<Drone> drone = droneService.getDroneBySerialNumber(serialNumber);

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
        List<Drone> drones = droneService.getAvailableDrones();

        // Filter the list of drones to only include drones in the IDLE or RETURNING state
        return drones.stream()
                .filter(d -> d.getState() == Drone.DroneState.IDLE || d.getState() == Drone.DroneState.RETURNING)
                .collect(Collectors.toList());
    }

    // Endpoint for checking the battery level for a given drone
    @GetMapping("/battery-level/{droneId}")
    public  @ResponseBody int getBatteryLevel(@PathVariable Long droneId) {
        // Retrieve the drone from the repository
        Optional<Drone> drone = droneService.getDroneById(droneId);

        // Return the battery level of the drone
        return drone.get().getBatteryCapacity();
    }

}


