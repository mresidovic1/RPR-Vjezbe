module com.example.gradovisvijeta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gradovisvijeta to javafx.fxml;
    exports com.example.gradovisvijeta;
}