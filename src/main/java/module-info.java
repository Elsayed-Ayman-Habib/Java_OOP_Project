module Package_one {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi.ooxml;
    requires poi;


    opens Package_one to javafx.fxml;
    exports Package_one;
}