import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
public class Medication {

    private String name;
    private int weight;
    private String code;

    public Medication() {
        // Default constructor
    }

    public Medication(String name, int weight, String code) {
        this.name = name;
        this.weight = weight;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
