module com.example.project_timetable {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.project_timetable to javafx.fxml;
    exports com.example.project_timetable;
}