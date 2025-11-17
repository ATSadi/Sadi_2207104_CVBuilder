module com.example.ahnafsadi_cvbuilder {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.ahnafsadi_cvbuilder to javafx.fxml;
    exports com.example.ahnafsadi_cvbuilder;
}
