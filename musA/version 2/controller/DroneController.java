package version 2.controller;

import com.example.dronecommunication.model.Drone;
import com.example.dronecommunication.model.Medication;
import com.example.dronecommunication.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @GetMapping("/{id}")
    public Optional<Drone> getDroneById(@PathVariable long id) {
        return droneService.getDroneById(id);
    }

    @PostMapping
    public Drone registerDrone(@RequestBody Drone drone) {
        return droneService.registerDrone(drone);
    }

    @PutMapping
    public void updateDrone(@RequestBody Drone drone) {
        droneService.updateDrone(drone);
    }

    @DeleteMapping("/{id}")
    public void deleteDrone(@PathVariable long id) {
        droneService.deleteDrone(id);
    }

    @GetMapping("/available")
    public List<Drone> getAvailableDrones() {
        return droneService.getAvailableDrones();
    }

    @PostMapping("/load")
    public void loadDrone(@RequestBody Drone drone, @RequestBody List<Medication> medications) {
        droneService.loadDrone(drone, medications);
    }
}

// To implement the DroneController class, you would need to do the following:

// Create a new Java class called DroneController and annotate it with @RestController to indicate that it is a Spring web controller that exposes REST endpoints.

// Inject the DroneService into the DroneController using the constructor.

// Define a method for each of the endpoints that you want to expose in the controller. For example, you might define the following methods:

// registerDrone: This method would allow clients to register a new drone by providing its serial number, model, weight limit, and battery capacity. It would use the DroneService to save the new drone to the database.
// getAllDrones: This method would allow clients to retrieve a list of all the registered drones. It would use the DroneService to fetch the list of drones from the database.
// getDroneById: This method would allow clients to retrieve a specific drone by its id. It would use the DroneService to fetch the drone from the database.
// updateDrone: This method would allow clients to update the details of an existing drone. It would use the DroneService to save the updated drone to the database.
// deleteDrone: This method would allow clients to delete a drone by its id. It would use the DroneService to delete the drone from the database.
// getAvailableDrones: This method would allow clients to retrieve a list of drones that are currently available for loading. It would use the DroneService to fetch the list of drones with the state "IDLE".
// loadDrone: This method would allow clients to load a drone with a list of medications. It would use the DroneService to update the drone's state and medications in the database.
// Annotate each of the methods with the appropriate HTTP request method (e.g. GET, POST, PUT, DELETE) and the request path (e.g. /drones, /drones/{id}, etc.) to indicate the endpoint that the method should be mapped to.

// Use the @RequestMapping annotation on the class level to specify the base path for all the endpoints in the controller.