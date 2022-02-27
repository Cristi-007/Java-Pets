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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

//    @FXML
//    private TableColumn<Employee, ?> birthdateColumn;

    @FXML
    private TableColumn<Employee, String> addressColumn;




    @FXML
    private TableColumn<Employee, LocalDate> birthdateColumn;
    private EmployeeDBAccess DBAccess;


    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();


    @FXML
    void openAddDialog(ActionEvent event) throws IOException, SQLException {
        // open Add window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addWindow.fxml"));
        AnchorPane container = loader.load();
        AddController addController = loader.getController();
        Scene scene = new Scene(container);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.setOnCloseRequest(new AddDialogCloseHandler());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
        Employee emp = addController.getResult();
        DBAccess.insert(emp);
        this.employeeData.add(emp);
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
    void openEditDialog(ActionEvent event) throws IOException {
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
//            Employee emp = editController.getData();
            this.employeeData.get(selectedRow).setName(editController.getData().getName());
//            this.employeeData.get(selectedRow).setBirthdate(editController.getData().getBirthdate());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Employee> emps = null;

        // de ce cere ca sa fie static????
        try {
            emps = EmployeeDBAccess.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.employeeData.addAll(emps);
        tableView.setItems(employeeData);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        idnpColumn.setCellValueFactory(new PropertyValueFactory<>("IDNP"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
//        birthdateColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
    }


}







































