package flowercatalog;

public class Flower {
    private String name;
    private float price;
    private float stemLenghtSm; // довжина стебла в см
    private String description;
    private byte[] image;
    private  GsColors color;
    public Flower(){
        name = "Квітка без імені";
        price = 0.0f;
        stemLenghtSm = 0.0f;
        description = "Без опису";
        color = GsColors.other;
        image = null;
    }
    public Flower(String Name, String Description, float Price, float StemLenghtSm, GsColors FColor, byte[] Image){
        this.name = Name;
        this.description = Description;
        this.price = Price;
        this.stemLenghtSm = StemLenghtSm;
        this.color = FColor;
        this.image = Image;
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
    public void setStemLenghtSm(float stemLenghtSm) {
        this.stemLenghtSm = stemLenghtSm;
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
    public float getStemLenghtSm() {
        return stemLenghtSm;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }
}
