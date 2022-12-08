public class Medication {
  
    private String name;
    private int weight;
    private String code;
    private String image;
    
    public Medication(String name, int weight, String code, String image) {
      this.name = name;
      this.weight = weight;
      this.code = code;
      this.image = image;
    }
    
    public String getName() {
      return this.name;
    }
    
    public int getWeight() {
      return this.weight;
    }
    
    public String getCode() {
      return this.code;
    }
    
    public String getImage() {
      return this.image;
    }
  }
  