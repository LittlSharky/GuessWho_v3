module be.kdg.screenreader {
    requires javafx.controls;
    requires javafx.fxml;
    requires freetts;


    opens be.kdg.screenreader to javafx.fxml;
    exports be.kdg.screenreader;
}