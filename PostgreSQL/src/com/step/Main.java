package com.step;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
//        new Employee("Vasile", "Eremia");

        EmployeeDao dao = new EmployeeDao();

        // INSERT
//        dao.create(new Employee("Maria", "Popescu"));

        // get all
        List<Employee> employeeList = dao.readAll();
        for(Employee emp: dao.readAll()){
            System.out.println(emp);
        };
//
//
//
//        // update
//        Employee emp = employeeList.get(4);
//        emp.setName("Jill");
//        emp.setSurname("Smith");
//
//        dao.update(emp);
//
//        // delete
        dao.delete(3);
    }
}
