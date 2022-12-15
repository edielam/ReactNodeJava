package com.dronecommunication.model;


import com.dronecommunication.components.AbstractEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DS_DRONE")
public class Drone extends AbstractEntity {
    public enum Model {LIGHT_WEIGHT, MIDDLE_WEIGHT, CRUISER_WEIGHT,
        HEAVY_WEIGHT;
    }
    public enum DroneState {IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING;
    }


    @Column(name = "SN", unique = true, length = 100, nullable = false)
    private String serialNumber;

    @Column(name = "MODEL", nullable = false)
    @Enumerated(EnumType.STRING)
    private Model model;

    @Column(name = "MAX_WEIGHT")
    private Double weightLimit;

    @Column(name = "BATTERY_LEVEL")
    private int batteryCapacity;

    @Column(name = "STATE", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DRONE_ID")
    private List<Medication> medications;

    public Drone() {
    }

    public Drone(String serialNumber, Model model, Double weightLimit, int batteryCapacity, DroneState state, List<Medication> medications) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.medications = medications;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryCapacity = batteryLevel;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}
