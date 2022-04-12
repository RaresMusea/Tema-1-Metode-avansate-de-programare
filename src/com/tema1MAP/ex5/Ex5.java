package com.tema1MAP.ex5;

public class Ex5 {

    public static double solve() {
        int result = 0;
        double sum = 0;
        for (int i = 1; i <= 99; i++) {
            double current = i / ((double) (i + 2));
            sum = sum + current;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
