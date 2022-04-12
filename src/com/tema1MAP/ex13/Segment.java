package com.tema1MAP.ex13;


public class Segment {
    private double a, b, c;

    //Constructor de initializare
    public Segment(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if (this.a == 0 && this.b == 0)
            System.out.print("Dreapta nu poate fi definita!");
    }

    //Afiseaza ecuatia dreptei
    @Override
    public String toString() {
        if (a == 0 && b == 0) {
            System.out.println("Dreapta nu poate fi definita!");
            return null;
        }
        if (a == 0) {
            return b + "y=" + c;
        }

        if (b == 0) {
            return a + "x=" + c;
        }
        return a + "x" + (b > 0 ? "+" : "") + b + "y=" + c;
    }

    //Ofera informatii referitoare la o dreapta caracterizata prin ecuatia ei
    public void checkSegment() {
        if (isHorizontal()) {
            System.out.println("Dreapta este orizontala");
            return;
        }
        if (isVertical()) {
            System.out.println("Dreapta este verticala");
        }
    }

    //Verifica daca dreapta curenta este sau nu orizontala
    public boolean isHorizontal() {
        return a == 0;
    }

    //Verifica daca dreapta curenta este sau nu verticala
    public boolean isVertical() {
        return b == 0;
    }

    //Obtine panta dreptei
    public double getSlope() {
        if (isVertical()) {
            System.out.println("Panta unei drepte vertifcale nu este definita!");
            return Double.MAX_VALUE;
        }
        return -b / a;
    }

    //Verifica daca dreapta curenta este paralela cu dreapta s2, pasata drept parametru
    public boolean isParallelTo(Segment s2) {
        return (this.isVertical() && s2.isVertical()) || (this.getSlope() == s2.getSlope());
    }

    //Verifica daca dreapta curenta este perpendiculara pe dreapta s2, pasata drept parametru
    public boolean isPerpendicularTo(Segment s2) {
        return (this.getSlope() * s2.getSlope() == -1) || (this.isHorizontal() && s2.isVertical()) || (this.isVertical() && s2.isHorizontal());
    }
}

