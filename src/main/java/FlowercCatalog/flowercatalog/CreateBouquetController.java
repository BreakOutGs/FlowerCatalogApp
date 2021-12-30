package FlowercCatalog.flowercatalog;

import flowercatalog.Bouquet;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class CreateBouquetController {

    List<Bouquet> bouquetCatalog;

    @FXML
    public void initialize(){
        bouquetCatalog = CatalogSingleton.getInstance().getBouquetCatalog();
    }

    @FXML
    private TextArea BouquetDescription;

    @FXML
    private TextField BouquetName;
    @FXML
    private void createBouquet(){
        String bouquetName = BouquetName.getText();
        String bouquetDescription = BouquetDescription.getText();
        Bouquet bouquet = new Bouquet(null,null,bouquetName,bouquetDescription);
        bouquetCatalog.add(bouquet);
    }

}
