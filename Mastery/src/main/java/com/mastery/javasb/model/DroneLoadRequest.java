package com.mastery.javasb.model;

import java.util.List;

public class DroneLoadRequest {

    private String droneId;
    private List<Medication> medicationList;

    public DroneLoadRequest(String droneId, List<Medication> medicationList) {
        this.droneId = droneId;
        this.medicationList = medicationList;
    }

    public String getDroneId() {
        return droneId;
    }

    public void setDroneId(String droneId) {
        this.droneId = droneId;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

}
// This class represents the request body for the /load endpoint.
// It has two properties: droneId, which is the ID of the drone to
// load, and medicationList, which is a list of medication items to
// load onto the drone. The class has getters and setters for these
// properties. It also has a constructor that accepts these two properties
// as arguments. This class is used by the DroneController class
// to load medication onto a drone.
