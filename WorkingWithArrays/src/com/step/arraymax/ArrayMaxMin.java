package com.step.arraymax;

public class ArrayMaxMin {

    public int maxNumber(int arr[]) {
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
            }
        }
        return maxNumber;
    }

    public int minNumber(int arr[]) {
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minNumber) {
                minNumber = arr[i];
            }
        }
        return minNumber;
    }

}
