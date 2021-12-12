package com.step.arraysum;

public class ArraySum {

    public int arraySum(int arr[]) {
        int sum =0;
        for(int item: arr ) {
            sum += item;
        }
        return sum;
    }
}
