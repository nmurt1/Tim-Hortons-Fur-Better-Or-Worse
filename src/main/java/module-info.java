module com.example.furbetterorworse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.furbetterorworse to javafx.fxml;
    exports com.example.furbetterorworse;
}