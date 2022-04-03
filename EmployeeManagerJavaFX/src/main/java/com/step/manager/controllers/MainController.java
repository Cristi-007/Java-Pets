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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class MainController implements Initializable {

    private List<Employee> importedEmployees = new ArrayList<>();
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

        // Example 1
//        String searchIDNP = searchIDNPTextField.getText();
//        LocalDate searchBithdate = searchDatePicker.getValue();
//
//        List<Employee> Employees = DBAccess.readAll();
//
//        List<Employee> emps =  DBAccess.search(searchIDNP,searchBithdate);
//
//        this.employeeData.clear();
//
//        if(emps != null){
//            insertDataInTable(emps);
//        }



//        Example 2
        List<Employee> Employees = DBAccess.readAll();

        if (!searchIDNPTextField.getText().isEmpty()  && searchDatePicker.getValue() == null){
            Employees = Employees.stream()
                    .filter((Employee emp) -> Objects.equals(emp.getIDNP(), searchIDNPTextField.getText()) )
                    .collect(Collectors.toList());

        }else if (searchIDNPTextField.getText().isEmpty() && searchDatePicker.getValue() != null){
            Employees = Employees.stream()
                    .filter((Employee emp) -> Objects.equals(emp.getBirthdate(), searchDatePicker.getValue()) )
                    .collect(Collectors.toList());

        } else if (!searchIDNPTextField.getText().isEmpty() && searchDatePicker.getValue() != null){
            Employees = Employees.stream()
                    .filter((Employee emp) -> Objects.equals(emp.getIDNP(), searchIDNPTextField.getText()) && Objects.equals(emp.getBirthdate(), searchDatePicker.getValue()))
                    .collect(Collectors.toList());

        }

        this.employeeData.clear();
        insertDataInTable(Employees);
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


    @FXML
    void exportData(ActionEvent event) throws IOException {
        DirectoryChooser chooser = new DirectoryChooser();
        Node node = (Node) event.getSource();

        File directory = chooser.showDialog(node.getScene().getWindow());
        File textFile = new File(directory, "test.txt");

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?");
        alert.setTitle("Please confirm you want to replace file");
        Optional<ButtonType> optionalButton = alert.showAndWait();
        if(optionalButton.get() == ButtonType.OK){
            FileWriter writer = new FileWriter(textFile);
            writer.write("Exported data");
            writer.flush();
            writer.close();
        }

    }

    @FXML
    void importData(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("CSV", "*.txt");
        chooser.getExtensionFilters().add(filter);

        Node node = (Node)event.getSource();
        File result = chooser.showOpenDialog(node.getScene().getWindow());
        FileReader reader = new FileReader(result);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String employeeText;
        while((employeeText = bufferedReader.readLine()) != null) {
            String[] data = employeeText.split(",");
            importedEmployees.add(new Employee(Integer.parseInt(data[0]), data[3], data[1], data[4], data[5], LocalDate.parse(data[2])));
            insertDataInTable(importedEmployees);
        }
    }

    @FXML
    void saveImportedData(ActionEvent event) throws SQLException {
        for (Employee emp: importedEmployees) {
            DBAccess.insert(emp);
        }
        importedEmployees.clear();
    }
}







































