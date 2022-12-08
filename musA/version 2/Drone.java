

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "drones")
public class Drone {

  private String serialNumber;
  private String model;
  private int weightLimit;
  private int batteryCapacity;
  private String state;

  public Drone() {}

  public Drone(String serialNumber, String model, int weightLimit, int batteryCapacity, String state) {
    this.serialNumber = serialNumber;
    this.model = model;
    this.weightLimit = weightLimit;
    this.batteryCapacity = batteryCapacity;
    this.state = state;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
