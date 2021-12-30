package com.step;

import java.util.Scanner;

public class Rectangle extends Shape {
    private int longSidesSize;
    private int shortSideSize;

    public Rectangle(String shapeName) {
        super(shapeName);
    }

    public int getLongSidesSize() {
        return longSidesSize;
    }

    public void setLongSidesSize(int longSidesSize) {
        this.longSidesSize = longSidesSize;
    }


    public int getShortSideSize() {
        return shortSideSize;
    }

    public void setShortSideSize(int shortSideSize) {
        this.shortSideSize = shortSideSize;
    }


    public void setRectangleVariables() {

        Scanner dataInsert = new Scanner(System.in);

        setNumberOfSides(4);

        System.out.println("Insert size (int) for Long Sides of rectangle: ");
        setLongSidesSize(dataInsert.nextInt());
        dataInsert.nextLine();

        System.out.println("Insert size (int) for Short Sides of rectangle: ");
        setShortSideSize(dataInsert.nextInt());
        dataInsert.nextLine();

        System.out.println("Insert a color for your shape: ");
        setColor(dataInsert.nextLine());
    }


    public void PerimeterCalculator (){
        int perimeter = 2 * (getLongSidesSize() + getShortSideSize());

        System.out.println("Rectangle perimeter is " + perimeter);
    }

    public void AreaCalculator() {
        int area = getLongSidesSize() * getShortSideSize();

        System.out.println("Rectangle area is " + area);
    }

}
