package flowercatalog;

public class Accessory {
    private float price;
    private String name;
    private String description;
    private GsColors color;
    public Accessory(){
        this.name = "Unnamed";
        this.description = "undescripted";
        this.color = GsColors.other;
        this.price = 0f;
    }
    public Accessory(String Name, String Description, GsColors Color, float Price){
        this.name = Name;
        this.description = Description;
        this.color = Color;
        this.price = Price;
    }
    public void setColor(GsColors color) {
        this.color = color;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public GsColors getColor() {
        return color;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }

}
