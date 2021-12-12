package com.step.reversearray;
import java.util.Collection;

public class ReverseArray {

    public int[] reverseArray(int arr[]) {
         int[] reversedArr = new int[arr.length];

         for(int i=0; i<arr.length; i++) {
             reversedArr[i] = arr[(arr.length - 1) - i];
         }
         return reversedArr;
    }

}
