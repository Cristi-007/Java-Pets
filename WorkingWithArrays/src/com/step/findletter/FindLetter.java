package com.step.findletter;

import java.util.Scanner;

public class FindLetter {

    Scanner dataInput = new Scanner(System.in);

    public void initializeCharArray(int len) {
        char[] charArray = new char[len];

        System.out.println("Insert " + len + " characters: ");

        for (int i=0; i<len; i++) {
            charArray[i] = dataInput.next().charAt(0);
        }

        for (char item: charArray) {
            if(item == 'a' || item == 'e' || item == 'i' || item == 'o' || item == 'u' || item == 'y' || item == 'w') {
                System.out.println(item + " - vowel.");
            } else {
                System.out.println(item + " - consonant.");
            }
        }
    }

}
