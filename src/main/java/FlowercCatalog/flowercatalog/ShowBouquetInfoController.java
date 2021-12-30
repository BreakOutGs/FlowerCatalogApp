package FlowercCatalog.flowercatalog;

import flowercatalog.Accessory;
import flowercatalog.Bouquet;
import flowercatalog.Flower;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

import java.io.ByteArrayInputStream;

public class ShowBouquetInfoController {

    Bouquet bouquetToShow;

    @FXML
    private Text BouquetAccessoriesPrice;

    @FXML
    private VBox BouquetAccessoriesContainer;

    @FXML
    private TextArea BouquetDescription;

    @FXML
    private VBox BouquetFlowersContainer;

    @FXML
    private Text BouquetFlowersPrice;

    @FXML
    private Text BouquetName;

    @FXML
    private Text BouquetPrice;


    public  void initData(Bouquet bouquet){
        bouquetToShow = bouquet;
        BouquetAccessoriesPrice.setText(String.valueOf(bouquet.getAccessoryPrice()));
        BouquetDescription.setText(bouquet.getDescription());
        BouquetName.setText(bouquet.getName());
        BouquetFlowersPrice.setText(String.valueOf(bouquet.getFlowerPrice()));
        BouquetPrice.setText(String.valueOf(bouquet.getTotalPrice()));
        updateBouquetAccessoryPanels();
        updateBouquetFlowerPanels();

    }

    private void updateBouquetFlowerPanels() {
        boolean isContained;
        BouquetFlowersContainer.getChildren().clear();
        for (Flower flower : bouquetToShow.getFlowers()){
            BouquetFlowersContainer.getChildren().add(CreateFlowerPanel(flower));
        }
    }

    private void updateBouquetAccessoryPanels() {
        boolean isContained;
        BouquetAccessoriesContainer.getChildren().clear();
        for (Accessory accessory : bouquetToShow.getAccessories()){
            BouquetAccessoriesContainer.getChildren().add(CreateAccessoryPanel(accessory));
        }
    }

    private HBox CreateFlowerPanel(Flower flower) {
        HBox flowerPanel = new HBox();

        flowerPanel.setAlignment(Pos.CENTER_LEFT);
        flowerPanel.setStyle("-fx-background-color:  #ffeb94");
        VBox.setMargin(flowerPanel, new Insets(10.0, 10.0, 10.0, 10.0));

        ImageView flowerImage = new ImageView();
        HBox.setMargin(flowerImage, new Insets(5, 5, 5, 5));
        Image image;
        if (flower.getImage() == null) {
            image = new Image("file:src/main/resources/flowercatalog/DefaultFlowerImage.png");
        } else image = new Image(new ByteArrayInputStream(flower.getImage()));

        flowerImage.setImage(image);
        flowerImage.setFitWidth(33);
        flowerImage.setFitHeight(33);

        Text flowerNameText = new Text();
        flowerNameText.setText(flower.getName());
        flowerNameText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        flowerNameText.setTextAlignment(TextAlignment.CENTER);
        flowerNameText.setWrappingWidth(320);

        Text flowerPriceText = new Text();
        flowerPriceText.setText(String.valueOf(flower.getPrice()));
        flowerPriceText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        flowerPriceText.setTextAlignment(TextAlignment.CENTER);


        Text flowerPriceCaption = new Text();
        flowerPriceText.setText("Ціна:");
        flowerPriceText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        flowerPriceText.setTextAlignment(TextAlignment.CENTER);


        flowerPanel.getChildren().add(flowerImage);
        flowerPanel.getChildren().add(flowerNameText);
        flowerPanel.getChildren().add(flowerPriceCaption);
        flowerPanel.getChildren().add(flowerPriceText);

        return flowerPanel;
    }

    private HBox CreateAccessoryPanel(Accessory accessory){
        HBox accessoryPanel = new HBox();

        accessoryPanel.setAlignment(Pos.CENTER_LEFT);
        accessoryPanel.setStyle("-fx-background-color: #f2f5e9");
        VBox.setMargin(accessoryPanel,new Insets(10.0,10.0,10.0,10.0));

        ImageView accessoryImage = new ImageView();
        HBox.setMargin(accessoryImage,new Insets(5,5,5,5));
        Image image;
        image = new Image("file:src/main/resources/flowercatalog/defaultaccessory.png");


        accessoryImage.setImage(image);
        accessoryImage.setFitWidth(33);
        accessoryImage.setFitHeight(33);

        Text accessoryNameText = new Text();
        accessoryNameText.setText(accessory.getName());
        accessoryNameText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        accessoryNameText.setTextAlignment(TextAlignment.CENTER);
        accessoryNameText.setWrappingWidth(320);

        Text accessoryPriceText = new Text();
        accessoryNameText.setText(String.valueOf(accessory.getPrice()));
        accessoryNameText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        accessoryNameText.setTextAlignment(TextAlignment.CENTER);


        Text accessoryPriceCaption = new Text();
        accessoryNameText.setText("Ціна:");
        accessoryNameText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        accessoryNameText.setTextAlignment(TextAlignment.CENTER);



        accessoryPanel.getChildren().add(accessoryImage);
        accessoryPanel.getChildren().add(accessoryNameText);
        accessoryPanel.getChildren().add(accessoryPriceCaption);
        accessoryPanel.getChildren().add(accessoryPriceText);

        return  accessoryPanel;
    }


}
