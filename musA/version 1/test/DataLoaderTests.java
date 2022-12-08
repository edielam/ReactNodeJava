@SpringBootTest
public class DataLoaderTests {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DataLoader dataLoader;

    @Test
    public void testDataLoad() {
        // Execute the data loader
        dataLoader.run(null);

        // Verify that the expected data was loaded into the repository
        assertEquals(3, droneRepository.count());
        assertEquals("123", droneRepository.findById("123").getSerialNumber());
        assertEquals("456", droneRepository.findById("456").getSerialNumber());
        assertEquals("789", droneRepository.findById("789").getSerialNumber());
    }

}
// In this example, the testDataLoad method executes the DataLoader component and 
// verifies that the expected data was loaded into the repository. It does this by 
// using the DroneRepository class to count the number of drones in the repository,
//  and by using the findById method to retrieve individual drones by their ID and 
//  verify their properties. This test class ensures that the DataLoader component 
//  is working correctly and loading the required data into the database.