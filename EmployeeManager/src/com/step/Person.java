package com.step;

import com.step.enums.Gender;

public class Person {

    protected String name;
    protected String surname;
    protected String IDNP;
    protected Gender gender;
    protected String adress;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() { return gender;  }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getIDNP() {
        return IDNP;
    }
    public void setIDNP(String IDNP) {
        this.IDNP = IDNP;
    }


    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

}
