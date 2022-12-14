package com.dronecommunication.service;

import com.dronecommunication.model.Drone;
import com.dronecommunication.model.Medication;
import com.dronecommunication.repository.DroneRepository;
import com.dronecommunication.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private  MedicationRepository medicationRepository;

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

//    public void loadDrone(Optional<Drone> request, List<Medication> medications) {
//        Drone drone = request.get();
//        int totalWeight = 0;
//        for (Medication medication : medications) {
//            totalWeight += medication.getWeight();
//        }
//        if (totalWeight <= drone.getWeightLimit() && drone.getBatteryCapacity() >= 25) {
//            drone.setState(Drone.DroneState.LOADING);
//            drone.setMedications(medications);
//            updateDrone(Optional.of(drone));
//        }
//    }
    // other methods omitted

//    public void loadMedications(String serialNumber, List<Medication> medications) {
//        Optional<Drone> dreg = getDroneBySerialNumber(serialNumber);
//        Drone drone = dreg.get();
//        if (drone.getState() == Drone.DroneState.LOADING && drone.getBatteryCapacity() < 25) {
//            throw new IllegalStateException("Cannot load medications: drone is in LOADING state and has low battery capacity");
//        }
//        int totalMedicationWeight = 0;
//        for (Medication medication : medications) {
//            Double weight = medication.getWeight();
//            totalMedicationWeight += weight;
//        }
//        if (totalMedicationWeight > drone.getWeightLimit()) {
//            throw new IllegalArgumentException("Cannot load medications: total weight exceeds drone weight limit");
//        }
//        drone.setState(Drone.DroneState.LOADING);
//        drone.setMedications(medications);
//    }
    public void loadMedications(String serialNumber, List<Medication> medications) {
        // Retrieve the Drone object with the given serial number
        Optional<Drone> optionalDrone = droneRepository.findBySerialNumber(serialNumber);
        if (!optionalDrone.isPresent()) {
            throw new IllegalArgumentException("Drone with serial number " + serialNumber + " not found");
        }
        Drone drone = optionalDrone.get();

        // Calculate the total weight of the medications
        int totalWeight = 0;
        for (Medication medication : medications) {
            totalWeight += medication.getWeight();
        }

        // Check if the total weight of the medications is less than or equal to the weight limit of the drone
        if (totalWeight > drone.getWeightLimit()) {
            throw new IllegalArgumentException("Total weight of medications exceeds drone's weight limit");
        }

        // Check if the battery capacity of the drone is greater than or equal to 25%
        if (drone.getBatteryCapacity() < 25) {
            throw new IllegalArgumentException("Drone's battery capacity is below 25%");
        }

        // Insert the medications into the database
        medicationRepository.saveAll(medications);

        // Update the Drone object to reflect that it is now in the LOADING state
        drone.setState(Drone.DroneState.LOADING);
        droneRepository.save(drone);
    }



    public Optional<Drone> getDroneBySerialNumber(String serialNumber) {
        Optional<Drone> drone = droneRepository.findBySerialNumber(serialNumber);
        return drone;
    }

    public List<Medication> getLoadedMedication(String serialNumber) {
        Optional<Drone> drone = droneRepository.findBySerialNumber(serialNumber);
        return drone.get().getMedications();
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