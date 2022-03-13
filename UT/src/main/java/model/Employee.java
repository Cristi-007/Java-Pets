package model;

import java.time.LocalDate;
import java.util.Locale;

public class Employee {
    private Integer id;
    private String name;
    private Gender gemder;
    private LocalDate birhdate;

    public Employee(Integer id, String name, Gender gemder, LocalDate birhdate) {
        this.id = id;
        this.name = name;
        this.gemder = gemder;
        this.birhdate = birhdate;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String value = Character.toString(name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase();
        this.name = value;
    }

}












































