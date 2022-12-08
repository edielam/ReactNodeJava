@RestController
@RequestMapping("/api")
public class DroneController {

    @Autowired
    private DroneRepository droneRepository;

    // Endpoint for registering a drone
    @PostMapping("/register")
    public void registerDrone(@RequestBody Drone drone) {
        droneRepository.save(drone);
    }

    // Endpoint for loading a drone with medication items
    @PostMapping("/load")
    public void loadDrone(@RequestBody DroneLoadRequest request) {
        // Retrieve the drone from the repository
        Drone drone = droneRepository.findById(request.getDroneId());

        // Load the medication items onto the drone
        for (Medication medication : request.getMedicationList()) {
            drone.addMedication(medication);
        }

        // Update the drone's state to LOADED
        drone.setState(DroneState.LOADED);

        // Save the updated drone to the repository
        droneRepository.save(drone);
    }

    // Endpoint for checking loaded medication items for a given drone
    @GetMapping("/loaded-medication/{droneId}")
    public List<Medication> getLoadedMedication(@PathVariable String droneId) {
        // Retrieve the drone from the repository
        Drone drone = droneRepository.findById(droneId);

        // Return the list of medication items loaded on the drone
        return drone.getLoadedMedication();
    }

    // Endpoint for checking available drones for loading
    @GetMapping("/available-drones")
    public List<Drone> getAvailableDrones() {
        // Retrieve all drones from the repository
        List<Drone> drones = droneRepository.findAll();

        // Filter the list of drones to only include drones in the IDLE or RETURNING state
        return drones.stream()
            .filter(d -> d.getState() == DroneState.IDLE || d.getState() == DroneState.RETURNING)
            .collect(Collectors.toList());
    }

    // Endpoint for checking the battery level for a given drone
    @GetMapping("/battery-level/{droneId}")
    public int getBatteryLevel(@PathVariable String droneId) {
        // Retrieve the drone from the repository
        Drone drone = droneRepository.findById(droneId);

        // Return the battery level of the drone
        return drone.getBatteryLevel();
    }

}
