package com.tema1MAP.ex2;

public class Ex2 {

    public static void factors(int number) {

        int copy = number;
        for (int i = 2; i < Math.sqrt(number); i++) {
            while (copy % i == 0) {
                System.out.print(i + " ");
                copy /= i;
            }
        }
    }

    public static void main(String[] args) {
        factors(120);
    }

}
