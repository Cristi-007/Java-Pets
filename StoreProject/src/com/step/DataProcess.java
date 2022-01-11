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

        System.out.println("\t\t\t\t**PRODUCT INFO**\n");
        System.out.println("  Naming:\t\t\t\t" + products[productIndex-1].getNaming());
        System.out.println("---------------------------------------------");
        System.out.println("  Price:\t\t\t\t" + products[productIndex-1].getPrice());
        System.out.println("---------------------------------------------");
        System.out.println("  Manufacturer:\t\t\t" + products[productIndex-1].getManufacturer());
        System.out.println("---------------------------------------------");

        System.out.println("\nTo return enter any number: ");
        menu.intInput();
    }


}
