package model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class EmployeeTest {

    public void setName_NormalName() {
        Employee employee = new Employee();

        employee.setName("John");
        //verificam daca numele obiectului employee este John


        if(employee.getName().equals("John")) {
            //ok
            Assertions.assertEquals

        } else {
//            throw new Exception("Test Failure");
        }
    }

}
