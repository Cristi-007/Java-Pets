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
    private boolean cancel = false;

    public boolean isCancel() {
        return cancel;
    }

    public Employee getResult() {
        return result;
    }

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
//         field checking
        if (nameTextField.getText() != null && !nameTextField.getText().isEmpty() && surnameTextField.getText() != null && !surnameTextField.getText().isEmpty() && idnpTextField.getText() != null && !idnpTextField.getText().isEmpty()) {
            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            LocalDate date = birthdatePicker.getValue();
            String idnp = idnpTextField.getText();
            String address = addressTextField.getText();
            result = new Employee(name, surname, idnp, address, date);
            closeWindow(event);

        } else { cancel=true; }
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
