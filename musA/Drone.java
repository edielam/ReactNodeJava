public class Drone {

    public enum DroneState {
        IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
    }

    private String id;
    private String serialNumber;
    private String model;
    private int weightLimit;
    private int batteryCapacity;
    private DroneState state;
    private List<Medication> medicationList;

    public Drone() {
        // Default constructor
    }

    public Drone(String serialNumber, String model, int weightLimit, int batteryCapacity, DroneState state) {
        this.id = UUID.randomUUID().toString();
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.medicationList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public void addMedication(Medication medication) {
        this.medicationList.add(medication);
    }
}

// I used the DroneState enum type instead of a string for creating a new 
// Drone instance because it provides type safety and ensures that only 
// valid states can be assigned to a Drone instance.

// It is defined as an inner class of the Drone class, which means 
// that it is only accessible from within the Drone class or from 
// any other class within the same package.