package com.step.manager.DBAccess;

import com.step.manager.dataModel.Employee;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class EmployeeDBAccess {

    // CONNECTION OPENING
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres", "1111");
        return connection;
    }


    // INSERT
    public void insert(Employee employee) throws SQLException {
        Connection connection = getConnection();
        String insert = "INSERT INTO main.employee(NAME, SURNAME, IDNP, ADDRESS, birthdate) values(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getSurname());
        statement.setString(3, employee.getIDNP());
        statement.setString(4, employee.getAddress()); // trimitem LocalDate.of()
        statement.setDate(5, Date.valueOf(employee.getBirthdate()));


        int row = statement.executeUpdate();
        if (row == 0) {
            System.out.println("Error: " + row + " rows have been inserted! ");
        } else {
            System.out.println("Success: " + row + " rows have been inserted! ");
        }

        statement.close();
        connection.close();
    }


    // UPDATE
    public void update(Employee employee) throws SQLException {
        Connection connection = getConnection();
        String update = "UPDATE main.employee set NAME=?, SURNAME = ?, IDNP = ?, " +
                "ADDRESS = ?, BIRTHDATE = ? where EMPLOYEE_ID = ?";
        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getSurname());
        statement.setString(3, employee.getIDNP());
        statement.setString(4, employee.getAddress());
        statement.setDate(5,  Date.valueOf(employee.getBirthdate()));
        statement.setInt(6, employee.getId());

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
        String delete = "DELETE from main.employee where EMPLOYEE_ID = ?";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setInt(1, id);

        int row = statement.executeUpdate();
        if (row == 0) {
            System.out.println("Error: " + row + " rows have been deleted! ");
        } else {
            System.out.println("Success: " + row + " rows have been deleted! ");
        }

        statement.close();
        connection.close();
    }


    // READ ALL
    public static List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        Connection connection = getConnection();
        String select = "SELECT * FROM main.employee order by EMPLOYEE_ID asc";

        PreparedStatement statement = connection.prepareStatement(select);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            int id = result.getInt("EMPLOYEE_ID");
            String name = result.getString("NAME");
            String surname = result.getString("SURNAME");
            String idnp = result.getString("IDNP");
//            LocalDate birthdate = result.getDate("BIRTHDATE").toLocalDate();   // De ce da NullPointerException????
            LocalDate birthdate = result.getObject("BIRTHDATE", LocalDate.class);

            String address = result.getString("ADDRESS");
            employees.add(new Employee(id, name, surname, idnp, address, birthdate));
        }
        statement.close();
        connection.close();
        return employees;
    }


    //SEARCH
    public static List<Employee> search(String searchIDNP, LocalDate searchBirthdate) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String select = null;

        Connection connection = getConnection();

        if (!searchIDNP.isEmpty()  && searchBirthdate == null){
            select = "SELECT * FROM main.employee where IDNP = ?";

        }else if (searchIDNP.isEmpty() && searchBirthdate != null){
            select = "SELECT * FROM main.employee where birthdate = ?";

        } else if (!searchIDNP.isEmpty() && searchBirthdate != null){
            select = "SELECT * FROM main.employee where IDNP = ? and birthdate = ?";

        } else {
            return null;
        }

        PreparedStatement statement = connection.prepareStatement(select);

        if (!searchIDNP.isEmpty()  && searchBirthdate == null){
            statement.setString(1,searchIDNP);

        }else if (searchIDNP.isEmpty() && searchBirthdate != null){
            statement.setDate(1, Date.valueOf(searchBirthdate));

        } else if (!searchIDNP.isEmpty() && searchBirthdate != null){
            statement.setString(1,searchIDNP);
            statement.setDate(2, Date.valueOf(searchBirthdate));

        } else {
            return null;
        }

        ResultSet result = statement.executeQuery();



        while (result.next()) {
            int id = result.getInt("EMPLOYEE_ID");
            String name = result.getString("NAME");
            String surname = result.getString("SURNAME");
            String idnp = result.getString("IDNP");
            LocalDate birthdate = result.getObject("BIRTHDATE", LocalDate.class);
            String address = result.getString("ADDRESS");
            employees.add(new Employee(id, name, surname, idnp, address, birthdate));
        }
        statement.close();
        connection.close();
        return employees;
    }
}
