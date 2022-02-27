package com.step.manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

    public void start(Stage stage) throws Exception {
        AnchorPane container = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
        stage.setScene(new Scene(container));
        stage.setTitle("EmployeeManager FX");
        stage.show();
    }
}












































