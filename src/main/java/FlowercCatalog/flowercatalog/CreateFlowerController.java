package FlowercCatalog.flowercatalog;

import flowercatalog.Catalog;
import flowercatalog.Flower;
import flowercatalog.GsColors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateFlowerController {
    List<String> colors = Stream.of(GsColors.values())
            .map(GsColors::name)
            .collect(Collectors.toList());
    List<Flower> flowerCatalog = CatalogSingleton.getInstance().getFlowerCatalog();

    @FXML
    TextField CreateFlowerName;
    @FXML
    TextField CreateFlowerLengthStem;
    @FXML
    TextField CreateFlowerPrice;
    @FXML
    TextArea CreateFlowerDescription;
    @FXML
    ChoiceBox<String> CreateFlowerColors;
    @FXML
    public void initialize(){
        CreateFlowerColors.setItems(FXCollections.observableList(colors));
        CreateFlowerColors.setValue("other");
    }
    @FXML
    protected  void CreateFlower(){
        String flowerName = CreateFlowerName.getText();
        String flowerDescription = CreateFlowerDescription.getText();
        float flowerStemLength = Float.valueOf(CreateFlowerLengthStem.getText());
        float flowerPrice = Float.valueOf(CreateFlowerPrice.getText());
        String flowerColor = CreateFlowerColors.getValue();
        Flower createdFlower = new Flower(flowerName,flowerDescription,
                flowerPrice,flowerStemLength,
                GsColors.valueOf(flowerColor),null);
        flowerCatalog.add(createdFlower);

    }





}
