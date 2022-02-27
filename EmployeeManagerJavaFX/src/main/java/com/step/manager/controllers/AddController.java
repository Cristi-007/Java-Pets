package com.step.manager.controllers;

import com.step.manager.dataModel.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddController {
    private Employee result;

    public Employee getResult() {
        return result;
    }

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private DatePicker birthdatePicker;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField idnpTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    void add(ActionEvent event) {
        // field checking
//        if (idTextField.getText() != null && !idTextField.getText().isEmpty()) {
//            Integer id = Integer.parseInt(idTextField.getText());
//            String name = nameTextField.getText();
//            LocalDate date = birthdatePicker.getValue();
//            result = new Employee(id, name, date);
//            System.out.println(result);
//            closeWindow(event);
//        }


            Integer id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            String idnp = idnpTextField.getText();
            String address = addressTextField.getText();
//            LocalDate date = birthdatePicker.getValue();
            result = new Employee(id, name, surname, idnp, address);
            System.out.println(result);
            closeWindow(event);
    }

    private void closeWindow (ActionEvent event) {
        Node button = (Node) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }


    @FXML
    void cancel(ActionEvent event) {
        closeWindow(event);
    }
}
