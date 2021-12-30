package FlowercCatalog.flowercatalog;

import flowercatalog.Accessory;
import flowercatalog.Bouquet;
import flowercatalog.Catalog;
import flowercatalog.Flower;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

import java.io.ByteArrayInputStream;

public class EditBouquetController {

    Bouquet editedBouquet;
    Catalog catalog;

    @FXML
    private VBox BouquetAccessoriesContainer;

    @FXML
    private TextArea BouquetDescription;

    @FXML
    private VBox BouquetFlowersContainer;

    @FXML
    private TextField BouquetName;


    @FXML
    private void editBouquet(ActionEvent event) {
        editedBouquet.setName(BouquetName.getText());
        editedBouquet.setDescription(BouquetDescription.getText());
    }

    private void updateBouquetFlowerPanels() {
        boolean isContained;
        BouquetFlowersContainer.getChildren().clear();
        for (Flower flower : catalog.getFlowerCatalog()){
           isContained = false;
           if(editedBouquet.getFlowers().contains(flower))
                isContained = true;
            BouquetFlowersContainer.getChildren().add(CreateFlowerPanel(flower,isContained));
        }
    }

    private void updateBouquetAccessoryPanels() {
        boolean isContained;
        BouquetAccessoriesContainer.getChildren().clear();
        for (Accessory accessory : catalog.getAccessoryCatalog()){
            isContained = false;
            if(editedBouquet.getAccessories().contains(accessory))
                isContained = true;
            BouquetAccessoriesContainer.getChildren().add(CreateAccessoryPanel(accessory,isContained));
        }
    }

    private HBox CreateFlowerPanel(Flower flower, boolean isContained) {
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

        CheckBox isContainCheckBox = new CheckBox("");
        HBox.setMargin(isContainCheckBox,new Insets(5,20,5,20));
        isContainCheckBox.setSelected(isContained);
        isContainCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
               if(newValue==true){
                   editedBouquet.getFlowers().add(flower);
               }
               else  editedBouquet.getFlowers().remove(flower);
            }
        });

        flowerPanel.getChildren().add(isContainCheckBox);
        flowerPanel.getChildren().add(flowerImage);
        flowerPanel.getChildren().add(flowerNameText);

        return flowerPanel;
    }

    private HBox CreateAccessoryPanel(Accessory accessory, boolean isContained){
        HBox accessoryPanel = new HBox();

        accessoryPanel.setAlignment(Pos.CENTER_LEFT);
        accessoryPanel.setStyle("-fx-background-color:  #f3e1fc");
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

        CheckBox isContainCheckBox = new CheckBox("");
        HBox.setMargin(isContainCheckBox,new Insets(5,20,5,20));
        isContainCheckBox.setSelected(isContained);
        isContainCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue==true){
                    editedBouquet.getAccessories().add(accessory);
                }
                else  editedBouquet.getAccessories().remove(accessory);
            }
        });

        accessoryPanel.getChildren().add(isContainCheckBox);
        accessoryPanel.getChildren().add(accessoryImage);
        accessoryPanel.getChildren().add(accessoryNameText);

        return  accessoryPanel;
    }

    public void initData(Bouquet bouquet) {
        editedBouquet = bouquet;
        catalog = CatalogSingleton.getInstance();
        BouquetName.setText(editedBouquet.getName());
        BouquetDescription.setText(editedBouquet.getDescription());
        updateBouquetFlowerPanels();
        updateBouquetAccessoryPanels();

    }
}
