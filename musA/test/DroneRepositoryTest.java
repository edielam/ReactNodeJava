@SpringBootTest
public class DroneRepositoryTests {

    @Autowired
    private DroneRepository droneRepository;

    @Test
    public void testSave() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Save the drone to the repository
        droneRepository.save(drone);

        // Verify that the drone was saved to the repository
        assertEquals(drone, droneRepository.findById("123"));
    }

    @Test
    public void testFindById() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Save the drone to the repository
        droneRepository.save(drone);

        // Find the drone by its ID
        Drone foundDrone = droneRepository.findById("123");

        // Verify that the found drone matches the original drone
        assertEquals(drone, foundDrone);
    }

    @Test
    public void testFindAll() {
        // Create a list of drones
        List<Drone> drones = Arrays.asList(
            new Drone("123", "Lightweight", 100, 75, DroneState.IDLE),
            new Drone("456", "Middleweight", 200, 50, DroneState.IDLE),
            new Drone("789", "Heavyweight", 500, 25, DroneState.IDLE)
        );

        // Save the drones to the repository
        drones.forEach(droneRepository::save);

        // Find all drones in the repository
        List<Drone> foundDrones = droneRepository.findAll();

        // Verify that the found drones match the original list of drones
        assertEquals(drones, foundDrones);
    }

    @Test
    public void testDelete() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Save the drone to the repository
        droneRepository.save(drone);

        // Delete the drone from the repository
        droneRepository.deleteById("123");

        // Verify that the drone was deleted from the repository
        assertFalse(droneRepository.existsById("123"));
    }

    @Test
    public void testCount() {
        // Create a list of drones
        List<Drone> drones = Arrays.asList(
            new Drone("123", "Lightweight", 100, 75, DroneState.IDLE),
            new Drone("456", "Middleweight", 200, 50, DroneState.IDL),
            new Drone("789", "Heavyweight", 500, 25, DroneState.IDLE)
        );

        // Save the drones to the repository
        drones.forEach(droneRepository::save);

        // Count the number of drones in the repository
        long count = droneRepository.count();

        // Verify that the correct number of drones was counted
        assertEquals(3, count);
    }
}
