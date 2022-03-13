package com.step.manager.dataModel;

import javafx.beans.property.*;
import java.time.LocalDate;


public class Employee {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty IDNP;
    private ObjectProperty<LocalDate> birthdate;
    private StringProperty address;


    public Employee(int id, String name, String surname, String IDNP, String address, LocalDate birthdate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.IDNP = new SimpleStringProperty(IDNP);
        this.birthdate = new SimpleObjectProperty<>(birthdate);
        this.address = new SimpleStringProperty(address);
    }


    public Employee(String name, String surname, String IDNP, String address, LocalDate birthdate) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.IDNP = new SimpleStringProperty(IDNP);
        this.birthdate = new SimpleObjectProperty<>(birthdate);
        this.address = new SimpleStringProperty(address);
    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getIDNP() {
        return IDNP.get();
    }

    public StringProperty IDNPProperty() {
        return IDNP;
    }

    public void setIDNP(String IDNP) {
        this.IDNP.set(IDNP);
    }



    public LocalDate getBirthdate() {
        return birthdate.get();
    }

    public ObjectProperty<LocalDate> birthdateProperty() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate.set(birthdate);
    }



    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", surname=" + surname +
                ", IDNP=" + IDNP +
                ", birthdate=" + birthdate +
                ", address=" + address +
                '}';
    }
}

















