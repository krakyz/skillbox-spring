module com.mod7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mod7 to javafx.fxml;
    exports com.mod7;
}