package com.step;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    // Dao -> Data Acces Object

    // CONNECTION OPENING
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres", "1111");
        return connection;
    }


    // INSERT
    public void create(Employee employee) throws SQLException {
        Connection connection = getConnection();
        String insert = "INSERT INTO main.employee(NAME, SURNAME) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getSurname());

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
    public void update(int id, String name, String surname, String address) throws SQLException {
        Connection connection = getConnection();
        String update = "Update main.employee set name=?, surname = ? where employee_id = ?";
        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setInt(3, id);

        int row = statement.executeUpdate();
        if(row == 0) {
            System.out.println("Error: " + row + " rows have been updated! ");
        }else {
            System.out.println("Success: " + row + " rows have been updated! ");
        }

        statement.close();
        connection.close();
    }


    public void update(Employee emp) throws SQLException {
        Connection connection = getConnection();
        String update = "UPDATE main.employee set name=?, surname = ? where employee_id = ?";
        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, emp.getName());
        statement.setString(2, emp.getSurname());
        statement.setInt(3, emp.getId());


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
        String delete = "DELETE from main.employee where employee_id = ?";
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


    // get all
    public List<Employee> readAll(String name) {
        String sql = "SELECT employee_id, name, surname where name like '%?%'";
        return null;
    }

    public List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        Connection connection = getConnection();
        String select = "SELECT employee_id, name, surname FROM main.employee order by employee_id asc";

        PreparedStatement statement = connection.prepareStatement(select);
        ResultSet result = statement.executeQuery();

        while(result.next()){
            int id = result.getInt("employee_id");
            String name = result.getString("name");
            String surname = result.getString("surname");
            employees.add(new Employee(id, name, surname));
        }
        statement.close();
        connection.close();
        return employees;
    }

}
