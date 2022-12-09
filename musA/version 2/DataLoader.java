package version 2;

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