package com.step;

public class DataProcess {
    Menu menu = new Menu();


    public double totalPriceCalculator(Product[] products) {
        double totalPrice = 0;

        for(int i=0; i<products.length; i++) {
            totalPrice += products[i].getPrice();
        }

        return totalPrice;
    }


    public void productView(Product[] products, int productIndex) {

        System.out.println("\t\t\tINFO\n");
        System.out.println("****");
        System.out.println("Product name: " + products[productIndex-1].getNaming());
        System.out.println("Product Price: " + products[productIndex-1].getPrice());
        System.out.println("Product Manufacturer: " + products[productIndex-1].getManufacturer());

        System.out.println("\nTo return enter any number: ");
        menu.intInput();
    }


}
