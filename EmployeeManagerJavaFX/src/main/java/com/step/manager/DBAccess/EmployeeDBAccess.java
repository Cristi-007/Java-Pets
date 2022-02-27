package com.step.manager.DBAccess;

import com.step.manager.dataModel.Employee;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDBAccess {

    // CONNECTION OPENING
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres", "1111");
        return connection;
    }


    // INSERT
    public void insert(Employee employee) throws SQLException {
        Connection connection = getConnection();
        String insert = "INSERT INTO main.employeeManager(NAME, SURNAME, IDNP, ADRESS) values(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getSurname());
        statement.setString(3, employee.getIDNP());
//        statement.setDate(4, employee.getBirthdate());
        statement.setString(5, employee.getAddress());

        int row = statement.executeUpdate();
        if(row == 0) {
            System.out.println("Error: " + row + " rows have been inserted! ");
        }else {
            System.out.println("Success: " + row + " rows have been inserted! ");
        }

        statement.close();
        connection.close();
    }


    // UPDATE
    public void update(Employee emp) throws SQLException {
        Connection connection = getConnection();
        String update = "UPDATE main.employeeManager set NAME=?, SURNAME = ?, IDNP=?, " +
                "ADRESS=? where ID = ?";
        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, emp.getName());
        statement.setString(2, emp.getSurname());
        statement.setString(3, emp.getIDNP());
//        statement.setDate(4, emp.getBirthdate());
        statement.setString(5, emp.getAddress());


        int row = statement.executeUpdate();
        if(row == 0) {
            System.out.println("Error: " + row + " rows have been updated! ");
        } else {
            System.out.println("Success: " + row + " rows have been updated! ");
        }

        statement.close();
        connection.close();
    }


    // DELETE
    public void delete(int id) throws SQLException {
        Connection connection = getConnection();
        String delete = "DELETE from main.employeeManager where ID = ?";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setInt(1, id);

        int row = statement.executeUpdate();
        if(row == 0) {
            System.out.println("Error: " + row + " rows have been deleted! ");
        } else {
            System.out.println("Success: " + row + " rows have been deleted! ");
        }

        statement.close();
        connection.close();
    }


    // read all
     public static List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        Connection connection = getConnection();
        String select = "SELECT * FROM main.employeeManager order by ID asc";

        PreparedStatement statement = connection.prepareStatement(select);
        ResultSet result = statement.executeQuery();

        try {
            while(result.next()){
                int id = result.getInt("ID");
                String name = result.getString("NAME");
                String surname = result.getString("SURNAME");
                String idnp = result.getString("IDNP");
//            LocalDate birthdate = result.getDate("BIRTHDATE")
                String address = result.getString("ADRESS");
                employees.add(new Employee(id, name, surname, idnp, address));
            }
            statement.close();
            connection.close();
            return employees;
        }
        catch (Exception e) {
            return null;
        }



    }
}
