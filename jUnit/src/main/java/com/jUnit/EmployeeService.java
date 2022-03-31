package com.jUnit;

import com.jUnit.Enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> getOnlyMales(List<Employee> employee) {
        return employee.stream()
                .filter((Employee emp) -> emp.getGender() == Gender.MALE)
                .collect(Collectors.toList());
    };


    public List<String> getAllNames(List<Employee> employee){
        List<String> names = new ArrayList<>();
        employee.forEach((emp) -> names.add(emp.getName()));
        return names;
    };


    public List<LocalDate> getAllbirthdates(List<Employee> employee) {
        List<LocalDate> birthDates = new ArrayList<>();
        employee.forEach((emp) -> birthDates.add(emp.getBirthdate()));
        return birthDates;
    };


    public boolean search(List<Employee> employee, String pattern) {
        return employee.stream()
                .anyMatch((emp) -> emp.getName().equals(pattern));
    }


    public String salaryCalculator(List<Employee> employee) {
        double salary = 0.0;

        for(int i=0; i< employee.size(); i++) {
            salary += employee.get(i).getSalary();
        }

        salary /= employee.size();
        String aaa = String.format("%.2f", salary);
        return aaa.replace(",",".");
    };
}










































