package FlowercCatalog.flowercatalog;

import flowercatalog.Accessory;
import flowercatalog.Bouquet;
import flowercatalog.Catalog;
import flowercatalog.Flower;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class HelloController {

    Catalog catalog = CatalogSingleton.getInstance();

    @FXML
    VBox FlowersPanelContainer;
    @FXML
    VBox AccessoryPanelContainer;
    @FXML
    VBox BouquetsPanelContainer;
    @FXML
    private Label welcomeText;
    @FXML
    private Button CreateFlowerButton;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){

    }
    @FXML
    protected void addFlower() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("CreateFlowerView.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Створення квітки");
            stage.setScene(scene);
            stage.showAndWait();

        updateFlowers();
        //FlowersPanelContainer.getChildren().add(CreateFlowerPanel(new Flower()));
    }

    @FXML
    protected void addAccessory() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("CreateAccessoryView.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Створення аксесуару");
        stage.setScene(scene);
        stage.showAndWait();

        updateAccessories();
    }
    @FXML
    protected  void editFlower(Flower flower) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "EditFlowerView.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        EditFlowerController controller = loader.getController();
        controller.initData(flower);

        stage.showAndWait();
        updateFlowers();
    }

    @FXML
    protected void addBouquet() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("CreateBouquetView.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Створення букету");
        stage.setScene(scene);
        stage.showAndWait();

        updateBouquets();
    }

    @FXML
    protected  void editAccessory(Accessory accessory) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "EditAccessoryView.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        EditAccessoryController controller = loader.getController();
        controller.initData(accessory);

        stage.showAndWait();
        updateAccessories();
    }

    @FXML
    protected  void editBoquet(Bouquet bouquet) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "EditBouquetView.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        EditBouquetController controller = loader.getController();
        controller.initData(bouquet);

        stage.showAndWait();
        updateAccessories();
    }

    @FXML
    protected  void showFlowerInfo(Flower flower) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "InfoFlowerView.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        ShowFlowerInfoController controller = loader.getController();
        controller.initData(flower);

        stage.showAndWait();
        updateFlowers();
    }

    @FXML
    protected  void showAccessoryInfo(Accessory accessory) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "InfoAccessoryView.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        ShowAccessoryInfoController controller = loader.getController();
        controller.initData(accessory);

        stage.showAndWait();
        updateFlowers();
    }

    @FXML
    protected  void showBouquetInfo(Bouquet bouquet) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "InfoBouquetView.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        ShowBouquetInfoController controller = loader.getController();
        controller.initData(bouquet);

        stage.showAndWait();
        updateFlowers();
    }


    private void updateFlowers(){
        FlowersPanelContainer.getChildren().clear();
        for(Flower flower : catalog.getFlowerCatalog()){
            FlowersPanelContainer.getChildren().add(CreateFlowerPanel(flower));
        }
    }

    private  void updateAccessories(){
        AccessoryPanelContainer.getChildren().clear();
        for(Accessory accessory : catalog.getAccessoryCatalog()){
            AccessoryPanelContainer.getChildren().add(CreateAccessoryPanel(accessory));
        }
    }

    private  void updateBouquets(){
        BouquetsPanelContainer.getChildren().clear();
        for(Bouquet bouquet : catalog.getBouquetCatalog()){
            BouquetsPanelContainer.getChildren().add(CreateBouquetPanel(bouquet));
        }
    }

    private  HBox CreateFlowerPanel(Flower flower){
        HBox flowerPanel = new HBox();

        flowerPanel.setAlignment(Pos.CENTER_LEFT);
        flowerPanel.setStyle("-fx-background-color:  #ffeb94");
        VBox.setMargin(flowerPanel,new Insets(10.0,10.0,10.0,10.0));

        ImageView flowerImage = new ImageView();
        HBox.setMargin(flowerImage,new Insets(5,5,5,5));
        Image image;
        if(flower.getImage()==null){
            image = new Image("file:src/main/resources/flowercatalog/defaultflower.png");
        }
        else image = new Image(new ByteArrayInputStream(flower.getImage()));

        flowerImage.setImage(image);
        flowerImage.setFitWidth(33);
        flowerImage.setFitHeight(33);

        Text flowerNameText = new Text();
        flowerNameText.setText(flower.getName());
        flowerNameText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        flowerNameText.setTextAlignment(TextAlignment.CENTER);
        flowerNameText.setWrappingWidth(320);

        Button flowerShowInfoButton = new Button();
        flowerShowInfoButton.setPrefWidth(85);
        flowerShowInfoButton.setText("Інформація");
        flowerShowInfoButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    showFlowerInfo(flower);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button flowerEditButton = new Button();
        flowerEditButton.setPrefWidth(85);
        flowerEditButton.setText("Редагувати");
        flowerEditButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    editFlower(flower);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button flowerDeleteButton = new Button();
        flowerDeleteButton.setPrefWidth(70);
        flowerDeleteButton.setText("Видалити");
        flowerDeleteButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                    deleteFlower(flower);
            }
        });

        flowerPanel.getChildren().add(flowerImage);
        flowerPanel.getChildren().add(flowerNameText);
        flowerPanel.getChildren().add(flowerShowInfoButton);
        flowerPanel.getChildren().add(flowerEditButton);
        flowerPanel.getChildren().add(flowerDeleteButton);

        return  flowerPanel;
    }

    private HBox CreateAccessoryPanel(Accessory accessory){
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

        Button accessoryShowInfoButton = new Button();
        accessoryShowInfoButton.setPrefWidth(85);
        accessoryShowInfoButton.setText("Інформація");
        accessoryShowInfoButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    showAccessoryInfo(accessory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button accessoryEditButton = new Button();
        accessoryEditButton.setPrefWidth(85);
        accessoryEditButton.setText("Редагувати");
        accessoryEditButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    editAccessory(accessory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button accessoryDeleteButton = new Button();
        accessoryDeleteButton.setPrefWidth(70);
        accessoryDeleteButton.setText("Видалити");
        accessoryDeleteButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                deleteAccessory(accessory);
            }
        });

        accessoryPanel.getChildren().add(accessoryImage);
        accessoryPanel.getChildren().add(accessoryNameText);
        accessoryPanel.getChildren().add(accessoryShowInfoButton);
        accessoryPanel.getChildren().add(accessoryEditButton);
        accessoryPanel.getChildren().add(accessoryDeleteButton);

        return  accessoryPanel;
    }

    private HBox CreateBouquetPanel(Bouquet bouquet){
        HBox bouquetPanel = new HBox();

        bouquetPanel.setAlignment(Pos.CENTER_LEFT);
        bouquetPanel.setStyle("-fx-background-color:  #94c8ff");
        VBox.setMargin(bouquetPanel,new Insets(10.0,10.0,10.0,10.0));

        ImageView bouquetImage = new ImageView();
        HBox.setMargin(bouquetImage,new Insets(5,5,5,5));
        Image image;
        image = new Image("file:src/main/resources/flowercatalog/defaultbouquet.png");


        bouquetImage.setImage(image);
        bouquetImage.setFitWidth(33);
        bouquetImage.setFitHeight(33);

        Text bouquetNameText = new Text();
        bouquetNameText.setText(bouquet.getName());
        bouquetNameText.setFont(Font.font("system", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        bouquetNameText.setTextAlignment(TextAlignment.CENTER);
        bouquetNameText.setWrappingWidth(320);

        Button accessoryShowInfoButton = new Button();
        accessoryShowInfoButton.setPrefWidth(85);
        accessoryShowInfoButton.setText("Інформація");
        accessoryShowInfoButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    showBouquetInfo(bouquet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button accessoryEditButton = new Button();
        accessoryEditButton.setPrefWidth(85);
        accessoryEditButton.setText("Редагувати");
        accessoryEditButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    editBoquet(bouquet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button accessoryDeleteButton = new Button();
        accessoryDeleteButton.setPrefWidth(70);
        accessoryDeleteButton.setText("Видалити");
        accessoryDeleteButton.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                deleteBouquet(bouquet);
            }
        });

        bouquetPanel.getChildren().add(bouquetImage);
        bouquetPanel.getChildren().add(bouquetNameText);
        bouquetPanel.getChildren().add(accessoryShowInfoButton);
        bouquetPanel.getChildren().add(accessoryEditButton);
        bouquetPanel.getChildren().add(accessoryDeleteButton);

        return  bouquetPanel;
    }

    private  void deleteFlower(Flower flower){
        catalog.getFlowerCatalog().remove(flower);
        updateFlowers();
    }

    private  void deleteAccessory(Accessory accessory){
        catalog.getAccessoryCatalog().remove(accessory);
        updateAccessories();
    }

    private  void deleteBouquet(Bouquet bouquet){
        catalog.getBouquetCatalog().remove(bouquet);
        updateBouquets();
    }

}