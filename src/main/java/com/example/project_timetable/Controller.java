package com.example.project_timetable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
    private static String filePathTimetableBeginning = "src\\main\\resources\\week_days";
    private static String filePathTaskList = "src\\main\\resources\\tasks.txt";
    private static String filePathHometask = "src\\main\\resources\\hometask.txt";
    private static String filePathMarks = "src\\main\\resources\\marks.txt";
    private static String filePathTeachers = "src\\main\\resources\\teachers.txt";

    public void initialize() throws IOException {//start view
        start();
    }

    enum Status{
        TIMETABLE,
        HOMETASK,
        TASKLIST,
        MARKS,
        CONTACTS,
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
        Timetable.setNumOfWeek(weekSpinner.getValue());
        Timetable.setSubject(subjectTimetable.getText());
        Timetable.setTeacher(teacherTimetable.getText());
        Timetable.changeTimetableItem();
        changeText(Timetable.StringOutput(weekSpinner.getValue()));
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
        TaskList.setNum(numTaskList.getText());
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
        Hometask.setNum(numHometask.getText());
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
        Teachers.setNum(numTeachers.getText());
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
    public Button marksAddButton;
    /**
     * the method add line in marks
     * @param actionEvent pressing the button
     */
    @FXML
    public void addMarksClick(ActionEvent actionEvent) throws IOException {
        Marks.setSubject(subject.getText());
        Marks.setMarks(marks.getText());
        Marks.setNum(numMarks.getText());
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
        if (status == Status.TIMETABLE){

            Timetable.deleteTimetableItem((String) dayDeleting.getValue(), weekSpinner.getValue(), Integer.parseInt(deleteNum1.getText()));
            changeText(Timetable.StringOutput(weekSpinner.getValue()));
        }

        if (status == Status.HOMETASK){
            Hometask.deleteHometask(Integer.parseInt(deleteNum.getText()));
            changeText(Hometask.StringOutput());
        }

        else if (status == Status.TASKLIST){
            TaskList.deleteTask(Integer.parseInt(deleteNum.getText()));
            changeText(TaskList.StringOutput());
        }

        else if (status == Status.MARKS){
            Marks.deleteMarks(Integer.parseInt(deleteNum.getText()));
            changeText(Marks.StringOutput());
        }

        else if (status == Status.CONTACTS){
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
    public Button timetableButton;

    /**
     * the method add new line in Timetable
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickTimetable(ActionEvent actionEvent) throws IOException {
        status = Status.TIMETABLE;
        ObservableList<String> days = FXCollections.observableArrayList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс");

        day.setItems(days);
        day.setValue("Пн");
        dayDeleting.setItems(days);//
        dayDeleting.setValue("Пн");
        spinnerInitialize();
        changeText(Timetable.StringOutput(weekSpinner.getValue()));

        weekSpinner.setVisible(true);

        grid1.setVisible(true);
        grid2.setVisible(false);
        grid3.setVisible(false);
        grid4.setVisible(false);
        grid5.setVisible(false);

        deletingGrid.setVisible(false);
        deletingGrid2.setVisible(true);


    }
    /**
     * button, which calls clickHometask
     */
    @FXML
    public Button hometaskButton;
    /**
     * the method add new line in Hometask
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickHometask(ActionEvent actionEvent) throws IOException {
        status = Status.HOMETASK;
        changeText(Hometask.StringOutput());
        grid1.setVisible(false);
        grid2.setVisible(true);
        grid3.setVisible(false);
        grid4.setVisible(false);
        grid5.setVisible(false);
        weekSpinner.setVisible(false);
        deletingGrid.setVisible(true);
        deletingGrid2.setVisible(false);
        numHometask.setText(Integer.toString(SecondaryFunctions.getNum(filePathHometask)));


    }
    /**
     * button, which calls clickTaskList
     */
    @FXML
    public Button taskListButton;
    /**
     * the method add new line in Tasklist
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickTaskList(ActionEvent actionEvent) throws IOException {
        status = Status.TASKLIST;
        changeText(TaskList.StringOutput());
        grid1.setVisible(false);
        grid2.setVisible(false);
        grid3.setVisible(true);
        grid4.setVisible(false);
        grid5.setVisible(false);
        weekSpinner.setVisible(false);
        deletingGrid.setVisible(true);
        deletingGrid2.setVisible(false);
        numTaskList.setText(Integer.toString(SecondaryFunctions.getNum(filePathTaskList)));

    }
    /**
     * button, which calls clickMarks
     */
    @FXML
    public Button marksButton;
    /**
     * the method add new line in Marks
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickMarks(ActionEvent actionEvent) throws IOException {
        status = Status.MARKS;
        changeText(Marks.StringOutput());
        grid1.setVisible(false);
        grid2.setVisible(false);
        grid3.setVisible(false);
        grid4.setVisible(true);
        grid5.setVisible(false);
        weekSpinner.setVisible(false);
        deletingGrid.setVisible(true);
        deletingGrid2.setVisible(false);
        numMarks.setText(Integer.toString(SecondaryFunctions.getNum(filePathMarks)));
    }
    /**
     * button, which calls clickTeachers
     */
    @FXML
    public Button teachersButton;
    /**
     * the method add new line in Teachers
     * @param actionEvent pressing the button
     */
    @FXML
    public void clickTeachers(ActionEvent actionEvent) throws IOException {
        status = Status.CONTACTS;
        changeText(Teachers.StringOutput());
        grid1.setVisible(false);
        grid2.setVisible(false);
        grid3.setVisible(false);
        grid4.setVisible(false);
        grid5.setVisible(true);
        weekSpinner.setVisible(false);
        deletingGrid.setVisible(true);
        deletingGrid2.setVisible(false);
        numTeachers.setText(Integer.toString(SecondaryFunctions.getNum(filePathTeachers)));
    }

    /**
     * text box
     */
    @FXML
    private TextFlow textflow;

    /**
     * the method add some text in textbox
     */
    @FXML
    public void pasteText() throws IOException {
        textflow.getChildren().add(text);
    }

    /**
     * some text
     */
    @FXML
    private Text text;

    /**
     * the method changes some text
     * @param s line, which include changed text
     */
    @FXML
    public void changeText(String s) throws IOException {
        text.setText(s);
        //text.setFont(Font.font("Arial", 30));
    }

    /**
     * all combinations of buttons for each function
     */
    @FXML
    public GridPane grid1, grid2, grid3, grid4, grid5, deletingGrid, deletingGrid2;

    /**
     * the method add subject in timetable
     * @param s line? which includes new subject
     */
    @FXML
    public void inputTimetable(String s) throws IOException {
        text.setText(s);
        //text.setFont(Font.font("Arial", 30));
    }

    /**
     * text for adding new subject in timetable
     */
    public TextField numTimetable, subjectTimetable, teacherTimetable;
    /**
     * text for adding new task in tasklist
     */
    public TextField numTaskList, task;
    /**
     * data for adding new task in tasklist
     */
    public DatePicker taskDate;
    /**
     * text for adding new hometask in hometask
     */
    public TextField numHometask, hometask, subjectHometask;
    /**
     * data for adding nw hometask in hometask
     */
    public DatePicker hometaskDate;
    /**
     * text for adding new teacher in teachers
     */
    public TextField numTeachers, name, subjectTeachers, inf;
    /**
     * text for addding new marksline in marks
     */
    public TextField numMarks, subject, marks;
    /**
     * text for deleting something
     */
    public TextField deleteNum, deleteNum1;

    public Spinner<Integer> weekSpinner;
    public void spinnerInitialize(){
        weekSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4));
        weekSpinner.getValueFactory().setValue(1);
        weekSpinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
                try {
                    changeText(Timetable.StringOutput(weekSpinner.getValue()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @FXML
    public void start() throws IOException {
        status = Status.TIMETABLE;
        ObservableList<String> days = FXCollections.observableArrayList("Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс");

        day.setItems(days);
        day.setValue("Пн");
        dayDeleting.setItems(days);//
        dayDeleting.setValue("Пн");
        spinnerInitialize();
        changeText(Timetable.StringOutput(weekSpinner.getValue()));

        weekSpinner.setVisible(true);

        grid1.setVisible(true);
        grid2.setVisible(false);
        grid3.setVisible(false);
        grid4.setVisible(false);
        grid5.setVisible(false);

        deletingGrid.setVisible(false);
        deletingGrid2.setVisible(true);


    }



}