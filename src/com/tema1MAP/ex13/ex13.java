package com.tema1MAP.ex13;

public class ex13 {
    public static void main(String[] args) {
        Segment sg = new Segment(-3, -2, 4);
        Segment sg2 = new Segment(3, 2, -5);
        System.out.println(sg.isParallelTo(sg2));
    }
}
