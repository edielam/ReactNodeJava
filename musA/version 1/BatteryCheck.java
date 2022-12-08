@Component
public class BatteryCheckTask implements Runnable {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private EventLog eventLog;

    @Override
    public void run() {
        // Retrieve all drones from the repository
        List<Drone> drones = droneRepository.findAll();

        // Check the battery level of each drone
        for (Drone drone : drones) {
            if (drone.getBatteryLevel() < 25) {
                // Create a new BatteryCheckEvent for the drone
                BatteryCheckEvent event = new BatteryCheckEvent(drone.getId(), drone.getBatteryLevel());

                // Add the event to the event log
                eventLog.addEvent(event);
            }
        }
    }

}
// This class has a method that retrieves all drones from the DroneRepository and checks their battery 
// levels. For each drone with a battery level below 25%, it creates a new BatteryCheckEvent
//  object and adds it to the event log. This class would be scheduled to run periodically 
//  using the @Scheduled annotation