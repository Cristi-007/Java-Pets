package com.step;

public class Product {
    protected String naming;
    protected double price;
    protected String manufacturer;


    public Product(String naming, double price, String manufacturer) {
        this.naming = naming;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
