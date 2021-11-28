package com.example.project_timetable;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The class calls all objects
 */
public class Controller {

    enum Status{
        Timetable,
        Hometask,
        Tasklist,
        Marks,
        Contacts,
    }
    Status status;
    /**
     * label, which appears on error
     */
    @FXML
    public static Label errorLabel;

    /**
     * the method shows errorLabel when we have an error in line
     * @param s line, which has a problem
     */
    @FXML
    public static void setError(String s) throws IOException {
        errorLabel.setText(s);
    }

    /**
     * button, which calls addItemClick
     */
    @FXML
    public Button timetableAddButton;

    /**
     * the method add line in timetable
     * @param actionEvent pressing the button
     */
    @FXML
    public void addItemClick(ActionEvent actionEvent) throws IOException {
        Timetable.setDay((String) day.getValue());
        Timetable.setItemNum(Integer.parseInt(numTimetable.getText()));
        Timetable.setSubject(subjectTimetable.getText());
        Timetable.setTeacher(teacherTimetable.getText());
        Timetable.changeTimetableItem();
        changeText(Timetable.StringOutput());
    }
    /**
     * button, which calls addTaskClick
     */
    @FXML
    public Button taskListAddButton;
    /**
     * the method add line in tasklist
     * @param actionEvent pressing the button
     */
    @FXML
    public void addTaskClick(ActionEvent actionEvent) throws IOException {
        LocalDate localDate = LocalDate.now();
        localDate = taskDate.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        TaskList.setDeadline(localDate.format(formatter));
        TaskList.setTask(task.getText());
        TaskList.addTask();
        changeText(TaskList.StringOutput());
    }
    /**
     * button, which calls hometaskAddButton
     */
    @FXML
    public Button hometaskAddButton;
    /**
     * the method add line in hometask
     * @param actionEvent pressing the button
     */
    @FXML
    public void addHometaskClick(ActionEvent actionEvent) throws IOException {
        LocalDate localDate = LocalDate.now();
        localDate = hometaskDate.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Hometask.setDeadline(localDate.format(formatter));
        Hometask.setSubject(subjectHometask.getText());
        Hometask.setHometask(hometask.getText());
        Hometask.addHometask();
        changeText(Hometask.StringOutput());
    }
    /**
     * button, which calls addTeacherClick
     */
    @FXML
    public Button teachersAddButton;
    /**
     * the method add line in teachers
     * @param actionEvent pressing the button
     */
    @FXML
    public void addTeacherClick(ActionEvent actionEvent) throws IOException {
        Teachers.setNum(num.getText());
        Teachers.setSubject(subjectTeachers.getText());
        Teachers.setName(name.getText());
        Teachers.setInf(inf.getText());
        Teachers.addTeacher();
        changeText(Teachers.StringOutput());
    }
    /**
     * button, which calls addMarksClick
     */
    @FXML
    public Button MarksAddButton;
    /**
     * the method add line in marks
     * @param actionEvent pressing the button
     */
    @FXML
    public void addMarksClick(ActionEvent actionEvent) throws IOException {
        Marks.setSubject(subject.getText());
        Marks.setMarks(marks.getText());
        Marks.addMarks();
        changeText(Marks.StringOutput());
    }

    /**
     * ComboBox include all buttons for deleting
     */
    @FXML
    public ComboBox dayDeleting;
    /**
     * button, which calls deleting
     */
    @FXML
    public Button deletingButton;
    @FXML
    /**
     * the method deletes line in marks
     */
    public void deleting(ActionEvent actionEvent) throws IOException {
        if (status == Status.Timetable){
            ObservableList<String> days = FXCollections.observableArrayList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс");
            day.setItems(days);
            day.setValue("Пн");
            Timetable.deleteTimetableItem((String) dayDeleting.getValue(), Integer.parseInt(deleteNum1.getText()));
            changeText(Timetable.StringOutput());
        }

            if (status == Status.Hometask){
                Hometask.deleteHometask(Integer.parseInt(deleteNum.getText()));
                changeText(Hometask.StringOutput());
            }

            else if (status == Status.Tasklist){
                TaskList.deleteTask(Integer.parseInt(deleteNum.getText()));
                changeText(TaskList.StringOutput());
            }

            else if (status == Status.Marks){
                Marks.deleteMarks(Integer.parseInt(deleteNum.getText()));
                changeText(Marks.StringOutput());
            }

            else if (status == Status.Contacts){
                Teachers.deleteTeacher(Integer.parseInt(deleteNum.getText()));
                changeText(Teachers.StringOutput());
            }



    }

    /**
     * ComboBox of days
     */
    @FXML
    public ComboBox day;
    /**
     * button, which calls clickTimetable
     */
    @FXML
    public Button TimetableButton;

    /**
     * the method add new line in Timetable
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickTimetable(ActionEvent actionEvent) throws IOException {
        status = Status.Timetable;
        ObservableList<String> days = FXCollections.observableArrayList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс");
        dayDeleting.setItems(days);
        dayDeleting.setValue("Пн");
        changeText(Timetable.StringOutput());

        Grid1.setVisible(true);
        Grid2.setVisible(false);
        Grid3.setVisible(false);
        Grid4.setVisible(false);
        Grid5.setVisible(false);

        DeletingGrid.setVisible(false);
        DeletingGrid2.setVisible(true);

    }
    /**
     * button, which calls clickHometask
     */
    @FXML
    public Button HometaskButton;
    /**
     * the method add new line in Hometask
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickHometask(ActionEvent actionEvent) throws IOException {
        status = Status.Hometask;
        changeText(Hometask.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(true);
        Grid3.setVisible(false);
        Grid4.setVisible(false);
        Grid5.setVisible(false);
        DeletingGrid.setVisible(true);
        DeletingGrid2.setVisible(false);

    }
    /**
     * button, which calls clickTaskList
     */
    @FXML
    public Button TaskListButton;
    /**
     * the method add new line in Tasklist
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickTaskList(ActionEvent actionEvent) throws IOException {
        status = Status.Tasklist;
        changeText(TaskList.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(false);
        Grid3.setVisible(true);
        Grid4.setVisible(false);
        Grid5.setVisible(false);
        DeletingGrid.setVisible(true);
        DeletingGrid2.setVisible(false);

    }
    /**
     * button, which calls clickMarks
     */
    @FXML
    public Button MarksButton;
    /**
     * the method add new line in Marks
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickMarks(ActionEvent actionEvent) throws IOException {
        status = Status.Marks;
        changeText(Marks.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(false);
        Grid3.setVisible(false);
        Grid4.setVisible(true);
        Grid5.setVisible(false);
        DeletingGrid.setVisible(true);
        DeletingGrid2.setVisible(false);
    }
    /**
     * button, which calls clickTeachers
     */
    @FXML
    public Button TeachersButton;
    /**
     * the method add new line in Teachers
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickTeachers(ActionEvent actionEvent) throws IOException {
        status = Status.Contacts;
        changeText(Teachers.StringOutput());
        Grid1.setVisible(false);
        Grid2.setVisible(false);
        Grid3.setVisible(false);
        Grid4.setVisible(false);
        Grid5.setVisible(true);
        DeletingGrid.setVisible(true);
        DeletingGrid2.setVisible(false);
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
    public GridPane Grid1, Grid2, Grid3, Grid4, Grid5, DeletingGrid, DeletingGrid2;
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
    public TextField deleteNum, deleteNum1;

}