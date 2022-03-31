package com.jUnit;

import com.jUnit.Enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();
    List<Employee> testData = new ArrayList<>();


    @Test
    public void testGetOnlyMales(){
        testData.add(new Employee(1, "Eduard",LocalDate.of(1975,10,24), Gender.MALE, 2548.54));
        testData.add(new Employee(1, "Mihai",LocalDate.of(1996,9,15), Gender.MALE, 8968.00));
        testData.add(new Employee(1, "Ana",LocalDate.of(1990,1,9), Gender.FEMALE, 11655.58));
        List<Employee> males = employeeService.getOnlyMales(testData);

        Assertions.assertNotNull(males);
        Assertions.assertEquals(2, males.size());

    }



    @Test
    public void testgetAllNames() {
        testData.add(new Employee(1, "Eduard",LocalDate.of(1975,10,24), Gender.MALE, 2548.54));
        testData.add(new Employee(1, "Mihai",LocalDate.of(1996,9,15), Gender.MALE, 8968.00));
        testData.add(new Employee(1, "Ana",LocalDate.of(1990,1,9), Gender.FEMALE, 11655.58));
        List<String> names = employeeService.getAllNames(testData);

        Assertions.assertNotNull(names);
        Assertions.assertEquals(testData.size(), names.size());
    }

    @Test
    public void testGetAllbirthdates() {
        testData.add(new Employee(1, "Eduard",LocalDate.of(1975,10,24), Gender.MALE, 2548.54));
        testData.add(new Employee(1, "Mihai",LocalDate.of(1996,9,15), Gender.MALE, 8968.00));
        testData.add(new Employee(1, "Ana",LocalDate.of(1990,1,9), Gender.FEMALE, 11655.58));
        List<LocalDate> birthdates = employeeService.getAllbirthdates(testData);

        Assertions.assertNotNull(birthdates);
        Assertions.assertEquals(testData.size(), birthdates.size());

    }

    @Test
    public void testSearch(){
        testData.add(new Employee(1, "Eduard",LocalDate.of(1975,10,24), Gender.MALE, 2548.54));
        testData.add(new Employee(1, "Mihai",LocalDate.of(1996,9,15), Gender.MALE, 8968.00));
        testData.add(new Employee(1, "Ana",LocalDate.of(1990,1,9), Gender.FEMALE, 11655.58));

        Assertions.assertTrue(employeeService.search(testData, "Mihai"));
    }


    @Test
    public void testSalaryCalculator() {
        testData.add(new Employee(1, "Eduard",LocalDate.of(1975,10,24), Gender.MALE, 2548.54));
        testData.add(new Employee(1, "Mihai",LocalDate.of(1996,9,15), Gender.MALE, 8968.00));
        testData.add(new Employee(1, "Ana",LocalDate.of(1990,1,9), Gender.FEMALE, 11655.58));

        double mediumSalary = Double.parseDouble(employeeService.salaryCalculator(testData));

        Assertions.assertNotNull(mediumSalary);
        Assertions.assertEquals(mediumSalary, 7724.04);

    }

}
