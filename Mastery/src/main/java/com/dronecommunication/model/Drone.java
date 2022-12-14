package com.dronecommunication.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "DRONE")
public class Drone {
    public enum DroneState {
        IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
    }
//    public enum Model {
//        LIGHTWEIGHT, MIDDLEWEIGHT, CRUISERWEIGHT, HEAVYWEIGHT
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SERIAL_NUMBER", nullable = true, length = 100)
    private String serialNumber;
    @Column(name = "MODEL", nullable = false, length = 50)
    //@Enumerated(EnumType.STRING)
    private String model;
    @Column(name = "WEIGHT_LIMIT", nullable = false)
    private int weightLimit;
    @Column(name = "BATTERY_CAPACITY", nullable = false)
    private int batteryCapacity;
    @Column(name = "STATE", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneState state;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DRONE_ID")
    private List<Medication> medications;

    public Drone() {}

    public Drone(String serialNumber, String model, int weightLimit, int batteryCapacity, DroneState state) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public Drone(String serialNumber, String model, int weightLimit, int batteryCapacity, DroneState state, List<Medication> medications) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.medications = medications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
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
