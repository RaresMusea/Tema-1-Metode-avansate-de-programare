package com.tema1MAP.ex10;

public class Ex10 {
    public static void main(String[] args) {
        BigNumber bn = new BigNumber("98");
        BigNumber bn2 = new BigNumber("0");
        BigNumber sum = bn.divide(bn2);
        System.out.println(sum);

    }
}
