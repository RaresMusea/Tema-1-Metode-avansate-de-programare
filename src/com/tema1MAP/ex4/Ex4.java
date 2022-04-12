package com.tema1MAP.ex4;

public class Ex4 {
    public static void generate() {
        int rows = 8;
        int counter = 1;

        for (int i = rows; i > 0; i--) {
            for (int j = 1; j < i * 2; j++) {
                System.out.print("  ");
            }


            for (int j = 0; j <= counter - 1; j++) {
                System.out.printf("%2d  ", (int) (Math.pow(2, j)));
            }

            for (int j = counter - 1; j >= 1; j--)
                System.out.printf("%2d  ", (int) (Math.pow(2, j - 1)));

            System.out.println();
            counter++;

        }
    }

    public static void main(String[] args) {
        // write your code here
        generate();
    }
}

