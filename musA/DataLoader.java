@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private DroneRepository droneRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create a list of drones to preload
        List<Drone> drones = Arrays.asList(
            new Drone("123", "Lightweight", 100, 75, DroneState.IDLE),
            new Drone("456", "Middleweight", 200, 50, DroneState.IDLE),
            new Drone("789", "Cruiserweight", 300, 25, DroneState.IDLE)
        );

        // Save the drones to the database
        droneRepository.saveAll(drones);
    }

}

// To ensure that the required data is preloaded in the database, you could 
// create a DataLoader class that implements the ApplicationRunner interface 
// and is annotated with the @Component annotation. This class would be executed 
// by Spring when the application starts, and it would load the required data into the database.

// In this example, the run method creates a list of drones and saves them to 
// the database using the DroneRepository class. This class would be executed when 
// the application starts, preloading the required data into the database.