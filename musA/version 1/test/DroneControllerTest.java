@SpringBootTest
public class DroneControllerTests {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DroneController droneController;

    @Test
    public void testDroneRegistration() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Register the drone using the controller
        droneController.registerDrone(drone);

        // Verify that the drone was saved to the repository
        assertEquals(drone, droneRepository.findById("123"));
    }

    @Test
    public void testDroneLoading() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Register the drone using the controller
        droneController.registerDrone(drone);

        // Create a list of medication items to load on the drone
        List<Medication> medicationList = Arrays.asList(
            new Medication("Paracetamol", 10, "PARA001"),
            new Medication("Ibuprofen", 15, "IBU001")
        );

        // Load the medication onto the drone using the controller
        droneController.loadDrone(new DroneLoadRequest("123", medicationList));

        // Verify that the medication was loaded onto the drone
        assertEquals(medicationList, droneRepository.findById("123").getLoadedMedication());

        // Verify that the drone's state was updated to LOADED
        assertEquals(DroneState.LOADED, droneRepository.findById("123").getState());
    }

    @Test
    public void testGetAvailableDrones() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Register the drone using the controller
        droneController.registerDrone(drone);

        // Retrieve the list of available drones from the controller
        List<Drone> availableDrones = droneController.getAvailableDrones();

        // Verify that the list contains the registered drone
        assertTrue(availableDrones.contains(drone));
    }

    @Test
    public void testGetBatteryLevel() {
        // Create a new drone
        Drone drone = new Drone("123", "Lightweight", 100, 75, DroneState.IDLE);

        // Register the drone using the controller
        droneController.registerDrone(drone);

        // Retrieve the battery level of the drone from the controller
        int batteryLevel = droneController.getBatteryLevel("123");

        // Verify that the battery level matches the expected value
        assertEquals(75, batteryLevel);
    }

}
