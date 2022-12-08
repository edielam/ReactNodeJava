@Repository
public class DroneRepository {

    private final Map<String, Drone> drones = new HashMap<>();

    public void save(Drone drone) {
        drones.put(drone.getId(), drone);
    }

    public Drone findById(String id) {
        return drones.get(id);
    }

    public List<Drone> findAll() {
        return new ArrayList<>(drones.values());
    }

}

// I am using a HashMap data structure in the DroneRepository class 
// because it allows for efficient insertion, retrieval, and deletion of
//  elements based on a unique key. In this case, the key is the drone's ID, 
//  and the value is the Drone object itself. Using a HashMap allows for 
//  quick lookup of a drone by its ID, which is necessary for the functionality
//   of the REST API endpoints.

public interface DroneRepository extends CrudRepository<Drone, String> {
    String findById(String id);

    List<Drone> findByModel(String model);

    List<Drone> findByIdIn(List<String> ids);

    List<Drone> findByState(DroneState state);

    int updateBatteryCapacity(String id, int batteryCapacity);

}
