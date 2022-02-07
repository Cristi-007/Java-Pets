package com.step;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product[] goods = new Product[5];
        Menu menu = new Menu();
        DataProcess dataProcess = new DataProcess();

        for (int i=0; i< goods.length; i++) {

            switch (i) {
                case 0:
                    goods[i] = new Product("Lapte", 7.80, "Casuta Mea");
                    break;
                case 1:
                    goods[i] = new Product("Piine", 5.40, "Franzeluta");
                    break;
                case 2:
                    goods[i] = new Product("Torta 'Napoleon'", 120, "Panelino");
                    break;
                case 3:
                    goods[i] = new Product("Salam 'De Casa'", 89.20, "Rogob");
                    break;
                case 4:
                    goods[i] = new Product("Peste Afumat", 35, "Ocean Fish");
                    break;
            }
        }

        while (true) {
            int meniuChoosed;
            meniuChoosed = menu.mainMenu();

            switch (meniuChoosed) {
                case 1:
                    System.out.println("Please provide product number (1-5): ");
                    while(true) {
                        meniuChoosed = menu.intInput();

                        if (meniuChoosed> goods.length) {
                            System.out.println("Product with this number does not exist, please enter another number.");
                        } else {
                            dataProcess.productView(goods, meniuChoosed);
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Total price for all goods is: " + dataProcess.totalPriceCalculator(goods));
                    break;

                case 111: return;
            }

        }

    }
}
