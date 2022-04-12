package com.tema1MAP.ex9;

import java.util.Random;

public class Ex9 {
    public static void Collatz(int range) {
        Random rand = new Random();
        int number = rand.nextInt(range + range) - range;
        if (number < 0) {
            System.out.println("Conjunctura Collatz poate fi aplicata doar in cazul numerelor intregi pozitive!");
            return;
        }
        if (number < 100) {
            System.out.print(number + " ");
            while (number != 1) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = 3 * number + 1;
                }
                System.out.print(number + " ");
            }
        } else {
            int iterations = 0;
            long startTime = System.nanoTime();
            while (number != 1) {
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number = 3 * number + 1;
                }
                iterations++;
            }
            long endTime = System.nanoTime();
            double elapsedTime = (endTime - startTime) / (double) 1000000;
            System.out.println("Iteratii: " + iterations + "\nTimp de executie:" + elapsedTime + " ms.");
        }
    }


    public static void main(String[] args) {
        Collatz(340);
    }
}
