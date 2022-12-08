package com.mastery.javasb.repository;

import com.mastery.javasb.model.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
 public class DroneRepository {

     private final Map<String, Drone> drones = new HashMap<>();

     public void save(Drone drone) {
         drones.put(drone.getId(), drone);
     }

     public Drone findById(String id) {
         return drones.get(id);
     }

//     public List<Drone> findByIdIn(List<String> ids){
//         return
//     }

     public List<Drone> findAll() {
         return new ArrayList<>(drones.values());
     }

 }

//public interface DroneRepository extends CrudRepository<Drone, String> {
//
//    List<Drone> findByModel(String model);
//
//    List<Drone> findByIdIn(List<String> ids);
//
//    List<Drone> findByState(Drone.DroneState state);
//
//    int updateBatteryCapacity(String id, int batteryCapacity);
//
//}
