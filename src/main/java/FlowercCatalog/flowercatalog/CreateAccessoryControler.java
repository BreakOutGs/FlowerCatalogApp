package FlowercCatalog.flowercatalog;

import flowercatalog.Accessory;
import flowercatalog.Flower;
import flowercatalog.GsColors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateAccessoryControler {

    List<String> colors = Stream.of(GsColors.values())
            .map(GsColors::name)
            .collect(Collectors.toList());
    List<Accessory> accessoryCatalog = CatalogSingleton.getInstance().getAccessoryCatalog();

    @FXML TextField AccessoryName;
    @FXML TextField AccessoryPrice;
    @FXML TextArea AccessoryDescription;
    @FXML ChoiceBox<String> AccessoryColor;

    @FXML
    public void initialize(){
        AccessoryColor.setItems(FXCollections.observableList(colors));
        AccessoryColor.setValue("other");
    }
    @FXML
    protected  void CreateFlower(){
        String acessoryName = AccessoryName.getText();
        String acessoryDescription = AccessoryDescription.getText();
        float acessoryPrice = Float.parseFloat(AccessoryPrice.getText());
        String accessoryColor =  AccessoryColor.getValue();
        Accessory createdAccessory = new Accessory(acessoryName,acessoryDescription,
                GsColors.valueOf(accessoryColor), acessoryPrice);
        accessoryCatalog.add(createdAccessory);

    }

}
