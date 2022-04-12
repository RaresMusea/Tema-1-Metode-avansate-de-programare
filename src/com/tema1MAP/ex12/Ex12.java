package com.tema1MAP.ex12;

public class Ex12 {
    public static void main(String[] args) {
        RomanNumber rn = new RomanNumber("MMXXII");
        System.out.println(rn.fromRomanToArabic());
        rn.displayAsRomanNumber();
        rn.displayAsArabic();
    }
}
