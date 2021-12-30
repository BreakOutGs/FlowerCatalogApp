package FlowercCatalog.flowercatalog;

import flowercatalog.Flower;
import flowercatalog.GsColors;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EditFlowerController{
    List<String> colors = Stream.of(GsColors.values())
            .map(GsColors::name)
            .collect(Collectors.toList());
    Flower editFlower;
    @FXML
    TextField EditFlowerName;
    @FXML TextField EditFlowerLengthStem;
    @FXML TextField EditFlowerPrice;
    @FXML
    TextArea EditFlowerDescription;
    @FXML
    ChoiceBox<String> EditFlowerColors;

    @FXML
    protected  void EditFlower(){
        String flowerName = EditFlowerName.getText();
        String flowerDescription = EditFlowerDescription.getText();
        float flowerStemLength = Float.valueOf(EditFlowerLengthStem.getText());
        float flowerPrice = Float.valueOf(EditFlowerPrice.getText());
        String flowerColor = EditFlowerColors.getValue();

        editFlower.setName(flowerName);
        editFlower.setDescription(flowerDescription);
        editFlower.setColor(GsColors.valueOf(flowerColor));
        editFlower.setStemLenghtSm(flowerStemLength);
        editFlower.setPrice(flowerPrice);
    }

    public void initData(Flower flower){
        editFlower = flower;
        EditFlowerColors.setItems(FXCollections.observableList(colors));
        EditFlowerColors.setValue(editFlower.getColor().toString());
        EditFlowerName.setText(editFlower.getName());
        EditFlowerPrice.setText(String.valueOf(editFlower.getPrice()));
        EditFlowerLengthStem.setText(String.valueOf(editFlower.getPrice()));
        EditFlowerDescription.setText(editFlower.getDescription());

    }
}
