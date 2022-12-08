@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private BatteryCheckTask batteryCheckTask;

    @Bean
    public DroneRepository droneRepository() {
        return new DroneRepository();
    }

    @Bean
    public DroneController droneController(DroneRepository droneRepository) {
        return new DroneController(droneRepository);
    }

    @Scheduled(fixedRate = 60000)
    public void runBatteryCheckTask() {
        batteryCheckTask.run();
    }

}

// This code defines the Application class as a Spring Boot application and creates
//  beans for the DroneRepository and DroneController classes. It also injects the 
//  DroneRepository bean into the DroneController constructor so that the 
// controller has access to the repository. This allows the controller to use the 
// repository to store and retrieve drones and medications.

// the runBatteryCheckTask method is scheduled to run every 60 seconds (1 minute). 
// This method simply calls the run method of the BatteryCheckTask class 
// to perform the battery check and event logging.