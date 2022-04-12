package com.tema1MAP.ex11;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduceti sirul pentru care doriti sa afisati permutarile: ");
        String str = sc.next();
        System.out.println(StringPermutation.readAndGeneratePermutations(str));
    }
}
