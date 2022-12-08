public class Drone {
  
  private String serialNumber;
  private String model;
  private int weightLimit;
  private int batteryCapacity;
  private String state;
  
  public Drone(String serialNumber, String model, int weightLimit, int batteryCapacity, String state) {
    this.serialNumber = serialNumber;
    this.model = model;
    this.weightLimit = weightLimit;
    this.batteryCapacity = batteryCapacity;
    this.state = state;
  }
  
  public String getSerialNumber() {
    return this.serialNumber;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public int getWeightLimit() {
    return this.weightLimit;
  }
  
  public int getBatteryCapacity() {
    return this.batteryCapacity;
  }
  
  public String getState() {
    return this.state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
}
