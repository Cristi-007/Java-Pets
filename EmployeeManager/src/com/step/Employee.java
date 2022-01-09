package com.step;

public class Employee extends Person {
    protected String function;
    protected double salary;


    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }


    public double getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
