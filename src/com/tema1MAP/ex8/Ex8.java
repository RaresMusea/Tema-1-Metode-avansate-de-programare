package com.tema1MAP.ex8;

public class Ex8 {

    public static void solveQuadraticEquation(double a, double b, double c) {

        double delta = Math.pow(b, 2) - 4 * (a * c);
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta) / (2 * a));
            double x2 = (-b - Math.sqrt(delta) / (2 * a));
            System.out.println("Solutiile reale ale ecutatiei de gradul 2: " + a + "x^2" + (b > 0 ? "+" + b : "" + b) + "x" + ((c > 0) ? "+" : "") + c + ", sunt:\n\tx1=" + x1 + "\n\t" + "x2=" + x2);
            return;
        }
        if (delta < 0) {
            ComplexNumber x1 = new ComplexNumber(-b / (2 * a), -Math.sqrt(Math.abs(delta)) / (2 * a));
            ComplexNumber x2 = new ComplexNumber(-b / (2 * a), Math.sqrt(Math.abs(delta)) / (2 * a));
            System.out.println("Solutiile complexe ale ecutatiei de gradul 2: " + a + "x^2" + (b > 0 ? "+" + b : "" + b) + "x" + ((c > 0) ? "+" : "") + c + ", sunt:\n\tx1=" + x1 + "\n\t" + "x2=" + x2);
            return;
        }

        double x = -b / (2 * a);
        System.out.println("Solutia reala dubla a ecuatiei de gradul 2: " + a + "x^2" + (b > 0 ? "+" + b : "" + b) + "x" + ((c > 0) ? "+" : "") + c + ", este:\n\tx1=" + x);


    }

    public static void main(String[] args) {

        solveQuadraticEquation(8, -6, 2);
    }
}
