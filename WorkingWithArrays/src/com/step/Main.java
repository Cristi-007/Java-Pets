package com.step;

import com.step.arraysum.ArraySum;
import com.step.arraymax.ArrayMaxMin;
import com.step.findletter.FindLetter;
import com.step.reversearray.ReverseArray;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int len=0;
        Random randNumber = new Random();
        Scanner dataInput = new Scanner(System.in);

        System.out.println("Insert range for array: ");
        len = dataInput.nextInt();

        int[] intArray = new int[len];

        for(int i=0; i<len; i++) {
            intArray[i] = randNumber.nextInt(500);
        }

//        ArraySum calculateArraySum = new ArraySum();
//        System.out.println( calculateArraySum.arraySum(intArray) );


//        ReverseArray reverse = new ReverseArray();
//        int[] rev = reverse.reverseArray(intArray);
//        for (int i=0; i<len; i++) {
//            System.out.println(rev[i]);
//        }


//        ArrayMaxMin maxNumber = new ArrayMaxMin();
//        System.out.println( "Max number is: " + maxNumber.maxNumber(intArray) );
//        System.out.println( "Min number is: " + maxNumber.minNumber(intArray) );

        FindLetter findLetter = new FindLetter();
        findLetter.initializeCharArray(len);

    }
}
