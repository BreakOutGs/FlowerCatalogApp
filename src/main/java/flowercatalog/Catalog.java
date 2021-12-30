package flowercatalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<Flower> flowerCatalog;
    List<Accessory> accessoryCatalog;
    List<Bouquet> bouquetCatalog;
    String name;
    public Catalog(List<Flower> FlowerCatalog, List<Accessory> AccessoryCatalog,
                   List<Bouquet> BouquetCatalog, String Name){
        this.flowerCatalog = FlowerCatalog;
        this.accessoryCatalog = AccessoryCatalog;
        this.bouquetCatalog = BouquetCatalog;
        this.name = Name;
    }
    public Catalog(){
        flowerCatalog = new ArrayList<Flower>();
        accessoryCatalog = new ArrayList<Accessory>();
        bouquetCatalog =  new ArrayList<Bouquet>();
        name =  "EmptyCatalog";
    }

    public void setAccessoryCatalog(List<Accessory> accessoryCatalog) {
        this.accessoryCatalog = accessoryCatalog;
    }
    public void setBouquetCatalog(List<Bouquet> bouquetCatalog) {
        this.bouquetCatalog = bouquetCatalog;
    }
    public void setFlowerCatalog(List<Flower> flowerCatalog) {
        this.flowerCatalog = flowerCatalog;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Accessory> getAccessoryCatalog() {
        return accessoryCatalog;
    }
    public List<Bouquet> getBouquetCatalog() {
        return bouquetCatalog;
    }
    public List<Flower> getFlowerCatalog() {
        return flowerCatalog;
    }
    public String getName() {
        return name;
    }
    public void addFlower(Flower flower){
        flowerCatalog.add(flower);
    }
    public void removeFlower(Flower flower){
        flowerCatalog.remove(flower);
    }
    public void addAccesory(Accessory accessory){
        accessoryCatalog.add(accessory);
    }
    public void removeAccesory(Accessory accessory){
        accessoryCatalog.remove(accessory);
    }
    public void addBouquet(Bouquet bouquet){
        bouquetCatalog.remove(bouquet);
    }
    public void removeBouquet(Bouquet bouquet){
        bouquetCatalog.remove(bouquet);
    }
}
