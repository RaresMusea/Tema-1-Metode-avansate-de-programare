package com.tema1MAP.ex1;

public class Ex1 {


    public static void generateASCII_Values(char lowerBound, char upperBound) {
        for (int i = lowerBound; i <= (int) upperBound; i++) {
            char asciiValue = (char) i;
            System.out.print(asciiValue + " ");
        }
    }

    public static void main(String[] args) {

        generateASCII_Values('!', '~');
    }
}
