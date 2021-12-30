package com.step;

import java.util.Scanner;

public class Square extends Shape {
    private int sideSize;

    public int getSideSize() {
        return sideSize;
    }

    public void setSideSize(int sideSize) {
        this.sideSize = sideSize;
    }

    public Square(String shapeName) {
        super(shapeName);
    }


    public void setSquareVariables() {

        Scanner dataInsert = new Scanner(System.in);

        setNumberOfSides(4);

        System.out.println("Insert size (int) for one side of square: ");
        setSideSize(dataInsert.nextInt());
        dataInsert.nextLine();

        System.out.println("Insert a color for your shape: ");
        setColor(dataInsert.nextLine());
    }



    public void PerimeterCalculator (){
        int perimeter = getSideSize() * 4;

        System.out.println("Square perimeter is " + perimeter);
    }


    public void AreaCalculator() {

        int area = getSideSize() * getSideSize();

        System.out.println("Square area is " + area);
    }

}
