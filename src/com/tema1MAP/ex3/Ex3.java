package com.tema1MAP.ex3;

public class Ex3 {
    public static void patternI(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= i + 1; j++)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void patternII(int size) {
        for (int i = size; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void patternIII(int size) {
        int c = size - 1;
        for (int i = 0; i < size; i++) {
            int values = i + 1;
            for (int j = 0; j < size; j++) {
                if (j < c) {
                    System.out.print("  ");
                } else {
                    System.out.print(" " + values--);
                }
            }
            System.out.println();
            c--;
        }
        System.out.println();
    }

    public static void patternIV(int size) {
        int c = size - 1;

        for (int i = 0; i < size; i++) {
            int values = 1;
            for (int j = 0; j < size; j++) {
                if (j >= i)
                    System.out.print(" " + values++);
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // write your code here
        patternI(6);
        patternII(6);
        patternIII(6);
        patternIV(6);
    }
}

