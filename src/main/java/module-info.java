module com.example.comp1011s1st200287453 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.comp1011s1st200287453 to javafx.fxml;
    exports com.example.comp1011s1st200287453;
}