import enums.Gender;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private Gender gender;
    private LocalDate birthdate;


    public Employee(String name, double salary, Gender gender, LocalDate birthdate) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
