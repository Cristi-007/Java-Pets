package com.step;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    int selector;


    public int intInput() {
        int data = input.nextInt();
        input.nextLine();

        return data;
    }


    public int mainMenu() {
        System.out.println("\t\t\tMENU\n");
        System.out.println("\t1. Product info.");
        System.out.println("\t2. Total price");
        System.out.println("\t3.   EXIT\n");
        while (true)
        {
            selector = input.nextInt();
            if (selector==1 || selector==2 || selector==3) break;
            else System.out.println("You entered wrong option, please try again.");
        }
        switch (selector) {
            case 1: return 1;
            case 2: return 2;
            case 3: return 111;
        }
        return 0;
    }
}
