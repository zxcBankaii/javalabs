package com.epam.training.chapter1.varianta;

import java.math.BigInteger;

public class SumAndProduct {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Передайте целые числа аргументами командной строки");
            return;
        }

        BigInteger sum = BigInteger.ZERO;
        BigInteger product = BigInteger.ONE;
        for (String arg : args) {
            BigInteger value;
            try {
                value = new BigInteger(arg);
            } catch (NumberFormatException e) {
                System.out.println("Не целое число: " + arg);
                return;
            }
            sum = sum.add(value);
            product = product.multiply(value);
        }

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}
