package version 2.service;

import com.example.dronecommunication.model.Drone;
import com.example.dronecommunication.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateDrone(Drone drone) {
        droneRepository.save(drone);
    }

    public void deleteDrone(long id) {
        droneRepository.deleteById(id);
    }

    public List<Drone> getAvailableDrones() {
        return droneRepository.findByState("IDLE");
    }

    public void loadDrone(Drone drone, List<Medication> medications) {
        int totalWeight = 0;
        for (Medication medication : medications) {
            totalWeight += medication.getWeight();
        }
        if (totalWeight <= drone.getWeightLimit() && drone.getBatteryCapacity() >= 25) {
            drone.setState("LOADING");
            drone.setMedications(medications);
            updateDrone(drone);
        }
    }
}

// The DroneService class contains methods for managing the Drone entity, such 
// as getting all drones, getting a single drone by its ID, registering a new drone,
//  updating an existing drone, and deleting a drone. It also has a method for getting 
//  available drones (i.e. drones with a state of "IDLE"), and a method for loading a 
//  drone with medications. The loadDrone method checks the weight and battery capacity 
//  of the drone before setting its state to "LOADING" and adding the medications to its list.