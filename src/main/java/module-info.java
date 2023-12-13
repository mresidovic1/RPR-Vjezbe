module com.example.forma {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.forma to javafx.fxml;
    exports com.example.forma;
}