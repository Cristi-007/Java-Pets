package com.step;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner dataInsert = new Scanner(System.in);
        int i = 0;

        Object myShapes[] = new Object[3];


        while (i < 3) {
            System.out.println("Insert the name of shape you want to initialize (square, rectangle, circle):");
            String start = (dataInsert.nextLine());

            switch (start.toUpperCase(Locale.ROOT)) {
                case "SQUARE":
                    myShapes[i] = new Square(start.toUpperCase(Locale.ROOT));
                    ((Square) myShapes[i]).setSquareVariables();
                    break;

                case "RECTANGLE":
                    myShapes[i] = new Rectangle(start.toUpperCase(Locale.ROOT));
                    ((Rectangle) myShapes[i]).setRectangleVariables();
                    break;

                case "CIRCLE":
                    myShapes[i] = new Circle(start.toUpperCase(Locale.ROOT));
                    ((Circle) myShapes[i]).setCircleVariables();
                    break;
            }

            i++;
        }
        ;


        for(int j = 0; j < myShapes.length; j++) {
            if (myShapes[j] instanceof Square) {
                ((Square) myShapes[j]).PerimeterCalculator();
                ((Square) myShapes[j]).AreaCalculator();
                System.out.println(((Square) myShapes[j]).getColor());

            } else if (myShapes[j] instanceof Rectangle) {
                ((Rectangle) myShapes[j]).PerimeterCalculator();
                ((Rectangle) myShapes[j]).AreaCalculator();
                System.out.println(((Rectangle) myShapes[j]).getColor());

            } else if (myShapes[j] instanceof Circle) {
                ((Circle) myShapes[j]).PerimeterCalculator();
                ((Circle) myShapes[j]).AreaCalculator();
                System.out.println(((Circle) myShapes[j]).getColor());
            }

        }
    }
}
