package FlowercCatalog.flowercatalog;

import flowercatalog.Flower;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ShowFlowerInfoController {

    @FXML
    private Text FlowerColor;

    @FXML
    private TextArea FlowerDescription;

    @FXML
    private Text FlowerLengthStem;

    @FXML
    private Text FlowerName;

    @FXML
    private Text FlowerPrice;

    public void initData(Flower flower){
        FlowerName.setText(flower.getName());
        FlowerColor.setText(flower.getColor().toString());
        FlowerDescription.setText(flower.getDescription());
        FlowerPrice.setText(String.valueOf(flower.getPrice()));
        FlowerLengthStem.setText(String.valueOf(flower.getStemLenghtSm()));
    }

}
