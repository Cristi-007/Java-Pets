package com.step;

import com.step.calculator.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println( "Sum: " + calculator.sum(65,87));

        System.out.println( "Substraction: " + calculator.substraction(4569,3454));

        System.out.println( "Multiplication: " + calculator.multiplication(345,25));

        System.out.println( "Division: " + calculator.division(645846,253));
    }
}
