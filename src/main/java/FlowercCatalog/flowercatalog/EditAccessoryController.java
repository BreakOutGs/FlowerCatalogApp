package FlowercCatalog.flowercatalog;

import flowercatalog.Accessory;
import flowercatalog.GsColors;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditAccessoryController {

    Accessory editedAccessory;

    @FXML
    private ChoiceBox<String> AccessoryColor;

    @FXML
    private TextArea AccessoryDescription;

    @FXML
    private TextField AccessoryName;

    @FXML
    private TextField AccessoryPrice;

    public void initData(Accessory accessory){
        editedAccessory = accessory;
        AccessoryName.setText(accessory.getName());
        AccessoryDescription.setText(accessory.getDescription());
        AccessoryPrice.setText(String.valueOf(accessory.getPrice()));
        AccessoryColor.setValue(accessory.getColor().toString());
    }
    @FXML
    private void editAccessory(){
        String accessoryName = AccessoryName.getText();
        String accessoryDescription = AccessoryDescription.getText();
        float accessoryPrice = Float.valueOf(AccessoryPrice.getText());
        String accessoryColor = AccessoryColor.getValue().toString();

        editedAccessory.setName(accessoryName);
        editedAccessory.setDescription(accessoryDescription);
        editedAccessory.setColor(GsColors.valueOf(accessoryColor));
        editedAccessory.setPrice(accessoryPrice);
    }

}
