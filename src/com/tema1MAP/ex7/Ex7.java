package com.tema1MAP.ex7;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Ex7 {
    public static BigInteger factorial(int n) {
        BigInteger temp = new BigInteger("1");
        for (int i = 1; i <= n; i++)
            temp = temp.multiply(new BigInteger("" + i));
        return temp;
    }

    public static BigDecimal computeEulersNumber(int param) {
        BigDecimal e = new BigDecimal("0.0");
        for (int i = 1; i <= param; i++) {
            BigDecimal aux = new BigDecimal("1.0");
            BigDecimal temp = new BigDecimal(factorial(i));
            temp = aux.divide(temp, RoundingMode.HALF_UP);
            e = e.add(temp);
        }
        return e;
    }

    public static void main(String[] args) {

        System.out.println(computeEulersNumber(100));
        System.out.println(computeEulersNumber(1000));
        System.out.println(computeEulersNumber(10000));

    }
}
