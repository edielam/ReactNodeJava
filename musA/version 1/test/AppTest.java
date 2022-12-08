@SpringBootTest
public class ApplicationTests {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DroneController droneController;

    @Test
    public void testGetLoadedMedication() {
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

        // Retrieve the loaded medication from the controller
        List<Medication> loadedMedication = droneController.getLoadedMedication("123");

        // Verify that the loaded medication matches the expected list
        assertEquals(medicationList, loadedMedication);
    }

}

// Why is this the method chosen for the main test class?

// This is only an example of a test method that could be
//  included in the main test class. The testGetLoadedMedication method was chosen
//   as an example because it tests a relatively simple method in the 
//   DroneController class, which involves creating a new drone, registering it, 
//   loading medication onto it, and then retrieving the loaded medication. 
//   This test method can help ensure that the getLoadedMedication method is working
//    correctly and returning the expected results.