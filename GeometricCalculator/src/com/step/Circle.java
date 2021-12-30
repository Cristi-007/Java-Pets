package com.step;

import java.util.Scanner;

public class Circle extends Shape {
    private int radius;
    private double piVal = 3.14;

    public Circle(String shapeName) {
        super(shapeName);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getPiVal() {
        return piVal;
    }

    public void setCircleVariables() {

        Scanner dataInsert = new Scanner(System.in);

        setNumberOfSides(0);

        System.out.println("Insert radius (int) circle: ");
        setRadius(dataInsert.nextInt());
        dataInsert.nextLine();

        System.out.println("Insert a color for your shape: ");
        setColor(dataInsert.nextLine());
    }

    public void PerimeterCalculator() {
        double perimeter = 2 * getPiVal() * getRadius();

        System.out.println("Circle perimeter is " + perimeter);
    }

    public void AreaCalculator (){
        double area = getPiVal() * (getRadius() * getRadius());

        System.out.println("Circle area is " + area);
    }

}
