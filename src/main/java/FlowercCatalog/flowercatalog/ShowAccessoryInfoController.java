package FlowercCatalog.flowercatalog;

import flowercatalog.Accessory;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ShowAccessoryInfoController {

    @FXML
    private Text AccessoryColor;

    @FXML
    private TextArea AccessoryDescription;

    @FXML
    private Text AccessoryName;

    @FXML
    private Text AccessoryPrice;

    public void initData(Accessory accessory){
        AccessoryColor.setText(accessory.getColor().toString());
        AccessoryName.setText(accessory.getName());
        AccessoryPrice.setText(String.valueOf(accessory.getPrice()));
        AccessoryDescription.setText(accessory.getDescription());
    }

}
