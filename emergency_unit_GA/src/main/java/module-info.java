module com.example.emergency_unit_ga {
    requires javafx.controls;
    requires javafx.fxml;


    opens emergency_unit_ga_files to javafx.fxml;
    exports emergency_unit_ga_files;
}