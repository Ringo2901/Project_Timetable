package com.example.project_timetable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    public static Label errorLabel;
    @FXML
    public static void setError(String s) throws IOException {
        errorLabel.setText(s);
    }
    @FXML
    public Button timetableAddButton;
    @FXML
    public void addItemClick(ActionEvent actionEvent) throws IOException {
        Timetable.setDay((String) day.getValue());
        Timetable.setItemNum(Integer.parseInt(numTimetable.getText()));
        Timetable.setSubject(subjectTimetable.getText());
        Timetable.setTeacher(teacherTimetable.getText());
        Timetable.changeTimetableItem();
        changeText(Timetable.StringOutput());
    }
    @FXML
    public Button taskListAddButton;
    @FXML
    public void addTaskClick(ActionEvent actionEvent) throws IOException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        TaskList.setDeadline(localDate.format(formatter));
        TaskList.setTask(task.getText());
        TaskList.addTask();
        changeText(TaskList.StringOutput());
    }
    @FXML
    public Button hometaskAddButton;
    @FXML
    public void addHometaskClick(ActionEvent actionEvent) throws IOException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Hometask.setDeadline(localDate.format(formatter));
        Hometask.setSubject(subjectHometask.getText());
        Hometask.setHometask(hometask.getText());
        Hometask.addHometask();
        changeText(Hometask.StringOutput());
    }
    @FXML
    public Button teachersAddButton;
    @FXML
    public void addTeacherClick(ActionEvent actionEvent) throws IOException {
        Teachers.setNum(num.getText());
        Teachers.setSubject(subjectTeachers.getText());
        Teachers.setName(name.getText());
        Teachers.setInf(inf.getText());
        Teachers.addTeacher();
        changeText(Teachers.StringOutput());
    }
    @FXML
    public Button MarksAddButton;
    @FXML
    public void addMarksClick(ActionEvent actionEvent) throws IOException {
        Marks.setSubject(subject.getText());
        Marks.setMarks(marks.getText());
        Marks.addMarks();
        changeText(Marks.StringOutput());
    }
    @FXML
    public ComboBox day;
    @FXML
    public Button TimetableButton;
    @FXML
    public void clickTimetable(ActionEvent actionEvent) throws IOException {
        ObservableList<String> days = FXCollections.observableArrayList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс");
        day.setItems(days);
        day.setValue("Пн");
        changeText(Timetable.StringOutput());

        Grid1.setVisible(true);
        Grid2.setVisible(false);
        Grid3.setVisible(false);
        Grid4.setVisible(false);
        Grid5.setVisible(false);

    }
    @FXML
    public Button HometaskButton;
    @FXML
    public void clickHometask(ActionEvent actionEvent) throws IOException {
        changeText(Hometask.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(true);
        Grid3.setVisible(false);
        Grid4.setVisible(false);
        Grid5.setVisible(false);

    }
    @FXML
    public Button TaskListButton;
    @FXML
    public void clickTaskList(ActionEvent actionEvent) throws IOException {
        changeText(TaskList.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(false);
        Grid3.setVisible(true);
        Grid4.setVisible(false);
        Grid5.setVisible(false);

    }
    @FXML
    public Button MarksButton;
    @FXML
    public void clickMarks(ActionEvent actionEvent) throws IOException {
        changeText(Marks.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(false);
        Grid3.setVisible(false);
        Grid4.setVisible(true);
        Grid5.setVisible(false);
    }
    @FXML
    public Button TeachersButton;
    @FXML
    public void clickTeachers(ActionEvent actionEvent) throws IOException {
        changeText(Teachers.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(false);
        Grid3.setVisible(false);
        Grid4.setVisible(false);
        Grid5.setVisible(true);
    }
    @FXML
    private TextFlow textflow;
    @FXML
    public void pasteText() throws IOException {
        textflow.getChildren().add(text);
    }
    @FXML
    private Text text;
    @FXML
    public void changeText(String s) throws IOException {
        text.setText(s);
        //text.setFont(Font.font("Arial", 30));
    }
    @FXML
    public GridPane Grid1, Grid2, Grid3, Grid4, Grid5;
    @FXML
    public void inputTimetable(String s) throws IOException {
        text.setText(s);
        //text.setFont(Font.font("Arial", 30));
    }
    public TextField numTimetable, subjectTimetable, teacherTimetable;
    public TextField task;
    public DatePicker taskDate;
    public TextField hometask, subjectHometask;
    public DatePicker hometaskDate;
    public TextField num, name, subjectTeachers, inf;
    public TextField subject, marks;

}