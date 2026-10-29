package com.epam.training.chapter2.variantb;

import com.epam.training.chapter2.Developer;

import java.util.Scanner;

/** Вариант B, задание 7: перевод числа из десятичной системы в любую другую (2..36). */
public class BaseConverter {

    private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Десятичное число: ");
        long number = scanner.nextLong();
        System.out.print("Основание (2-36): ");
        int base = scanner.nextInt();

        try {
            System.out.println(number + " в системе с основанием " + base + " = " + convert(number, base));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Developer.printSignature();
    }

    static String convert(long number, int base) {
        if (base < 2 || base > DIGITS.length()) {
            throw new IllegalArgumentException("Основание должно быть от 2 до " + DIGITS.length());
        }
        if (number == 0) {
            return "0";
        }

        boolean negative = number < 0;
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            int remainder = (int) Math.abs(number % base);
            result.append(DIGITS.charAt(remainder));
            number /= base;
        }
        if (negative) {
            result.append('-');
        }
        return result.reverse().toString();
    }
}
