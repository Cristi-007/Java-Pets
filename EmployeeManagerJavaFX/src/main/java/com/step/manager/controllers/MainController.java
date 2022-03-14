package com.step.manager.controllers;

import com.step.manager.DBAccess.EmployeeDBAccess;
import com.step.manager.handlers.AddDialogCloseHandler;
import com.step.manager.dataModel.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



public class MainController implements Initializable {

    public TextField searchIDNPTextField;
    public DatePicker searchDatePicker;
    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> surnameColumn;

    @FXML
    private TableColumn<Employee, String> idnpColumn;

    @FXML
    private TableColumn<Employee, LocalDate> birthdateColumn;

    @FXML
    private TableColumn<Employee, String> addressColumn;


    private EmployeeDBAccess DBAccess = new EmployeeDBAccess();
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();


    public void insertDataInTable(List<Employee> emps) {
            this.employeeData.addAll(emps);
            tableView.setItems(employeeData);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
            idnpColumn.setCellValueFactory(new PropertyValueFactory<>("IDNP"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            birthdateColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
    }


    @FXML
    void openAddDialog(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addWindow.fxml"));
        AnchorPane container = loader.load();
        AddController addController = loader.getController();
        Scene scene = new Scene(container);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setOnCloseRequest(new AddDialogCloseHandler());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        // Error on press Cancel button
        if(!addController.isCancel()){
            this.employeeData.add(addController.getResult());
            DBAccess.insert(addController.getResult());
        }
    }

    @FXML
    void openDeleteDialog(ActionEvent event) throws SQLException {
        int selectedRow = tableView.getSelectionModel().getSelectedIndex();
        if(selectedRow != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
            alert.setTitle("Please confirm");
            Optional<ButtonType> optionalButton = alert.showAndWait();
            if(optionalButton.get() == ButtonType.OK){
                DBAccess.delete(employeeData.get(selectedRow).getId());
                this.employeeData.remove(selectedRow);
            }
        }
    }

    @FXML
    void openEditDialog(ActionEvent event) throws IOException, SQLException {
        int selectedRow = tableView.getSelectionModel().getSelectedIndex();
        if(selectedRow != -1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/editWindow.fxml"));
            AnchorPane container = loader.load();
            com.step.manager.controllers.EditController editController = loader.getController();
            editController.setData(employeeData.get(selectedRow));
            Scene scene = new Scene(container);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            this.employeeData.get(selectedRow).setName(editController.getData().getName());
            this.employeeData.get(selectedRow).setSurname(editController.getData().getSurname());
            this.employeeData.get(selectedRow).setIDNP(editController.getData().getIDNP());
            this.employeeData.get(selectedRow).setAddress(editController.getData().getAddress());
            this.employeeData.get(selectedRow).setBirthdate(editController.getData().getBirthdate());
            DBAccess.update(editController.getData());
        }
    }

    @FXML
    void resetButton(ActionEvent event) throws SQLException {
        List<Employee> emps =  DBAccess.readAll();

        this.employeeData.clear();
        insertDataInTable(emps);
        searchIDNPTextField.clear();
        searchDatePicker.getEditor().clear();
    }

    @FXML
    void searchButton(ActionEvent event) throws SQLException {
        String searchIDNP = searchIDNPTextField.getText();
        LocalDate searchBithdate = searchDatePicker.getValue();

        List<Employee> emps =  DBAccess.search(searchIDNP,searchBithdate);

        this.employeeData.clear();

        if(emps != null){
            insertDataInTable(emps);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Employee> emps = null;


        try {
            emps = DBAccess.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        insertDataInTable(emps);
    }
}







































