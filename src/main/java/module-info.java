module com.example.project_timetable {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    opens com.example.project_timetable to javafx.fxml;
    exports com.example.project_timetable;
}