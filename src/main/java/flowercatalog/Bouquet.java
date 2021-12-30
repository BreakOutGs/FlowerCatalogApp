package flowercatalog;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers;
    private List<Accessory> accessories;
    private String name;
    private String description;

    public Bouquet(){
        flowers = new ArrayList<Flower>();
        accessories = new ArrayList<Accessory>();
        name = "UnnamedBouqued";
        description = "Undescripted";
    }

    public Bouquet(List<Flower> Flowers, List<Accessory> Accessories, String Name, String Description){
        this.flowers = Flowers;
        this.accessories = Accessories;
        this.name = Name;
        this.description = Description;
        if(Flowers==null){
            this.flowers = new ArrayList<Flower>();
        }
        if(Accessories==null){
            this.accessories = new ArrayList<Accessory>();
        }
    }
    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Accessory> getAccessories() {
        return accessories;
    }
    public String getDescription() {
        return description;
    }
    public List<Flower> getFlowers() {
        return flowers;
    }
    public String getName() {
        return name;
    }
    public float getTotalPrice(){
        float price = 0f;
        for (Flower flower : flowers) {
            price+=flower.getPrice();
        }
        for (Accessory accessory : accessories) {
            price+=accessory.getPrice();
        }
        return price;
    }
    public float getAccessoryPrice(){
        float price=0f;
        for (Accessory accessory : this.getAccessories()){
            price+=accessory.getPrice();
        }
        return  price;
    }
    public float getFlowerPrice(){
        float price=0f;
        for (Flower flower : this.getFlowers()){
            price+=flower.getPrice();
        }
        return price;
    }
    public void addAccesory(Accessory accessory){
        accessories.add(accessory);
    }
    public void removeAccesory(Accessory accessory){
        accessories.add(accessory);
    }
    public void addFlower(Flower flower){
        flowers.add(flower);
    }
    public void removeFlower(Flower flower){
        flowers.add(flower);
    }
}
