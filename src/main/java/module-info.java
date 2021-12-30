module flowercatalog.flowercatalog {
    requires javafx.controls;
    requires javafx.fxml;


    opens FlowercCatalog.flowercatalog to javafx.fxml;
    exports FlowercCatalog.flowercatalog;
}