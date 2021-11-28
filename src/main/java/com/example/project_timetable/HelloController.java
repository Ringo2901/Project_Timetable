package com.example.project_timetable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The class calls the scene
 */
public class HelloController {
    /**
     * the useless text
     */
    @FXML
    private Label welcomeText;

    /**
     * the useless button
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}