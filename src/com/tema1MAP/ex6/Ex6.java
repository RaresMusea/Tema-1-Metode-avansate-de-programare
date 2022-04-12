package com.tema1MAP.ex6;

public class Ex6 {
    public static double computePIValue(int param) {
        final int COEFF = 4;
        double sum = 0;
        for (int i = 1; i <= param; i++) {
            sum += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return sum * COEFF;
    }

    public static void main(String[] args) {
        System.out.println(computePIValue(10000));
        System.out.println(computePIValue(20000));
        System.out.println(computePIValue(100000));
    }
}
