package com.dronecommunication.service;

import com.dronecommunication.model.Drone;
import com.dronecommunication.model.Medication;
import com.dronecommunication.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public Optional<Drone> getDroneById(long id) {
        return droneRepository.findById(id);
    }

    public Drone registerDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public void updateDrone(Optional<Drone> drone) {
        droneRepository.save(drone.get());
    }

    public void deleteDrone(long id) {
        droneRepository.deleteById(id);
    }

    public List<Drone> getAvailableDrones() {
        // Retrieve all drones from the repository
        List<Drone> drones = droneRepository.findAll();

        // Filter the list of drones to only include drones in the IDLE or RETURNING state
        return drones.stream()
                .filter(d -> d.getState() == Drone.DroneState.IDLE || d.getState() == Drone.DroneState.RETURNING)
                .collect(Collectors.toList());
    }

    public void loadDrone(Optional<Drone> request, List<Medication> medications) {
        Drone drone = request.get();
        int totalWeight = 0;
        for (Medication medication : medications) {
            totalWeight += medication.getWeight();
        }
        if (totalWeight <= drone.getWeightLimit() && drone.getBatteryCapacity() >= 25) {
            drone.setState(Drone.DroneState.LOADING);
            drone.setMedications(medications);
            updateDrone(Optional.of(drone));
        }
    }
    public List<Medication> getLoadedMedication(Long id) {
        Optional<Drone> drone = droneRepository.findById(id);
        return drone.get().getMedications();
    }

    public void droneSetState(Optional<Drone> drone, Drone.DroneState State){
         drone.get().setState(State);
    }

    public List<Drone> getByIdIn(List<String> ids) {
        return droneRepository.findByIdIn(ids);
    }
}

// The DroneService class contains methods for managing the Drone entity, such
// as getting all drones, getting a single drone by its ID, registering a new drone,
//  updating an existing drone, and deleting a drone. It also has a method for getting
//  available drones (i.e. drones with a state of "IDLE"), and a method for loading a
//  drone with medications. The loadDrone method checks the weight and battery capacity
//  of the drone before setting its state to "LOADING" and adding the medications to its list.