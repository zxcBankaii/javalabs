package com.epam.training.chapter2.varianta;

import com.epam.training.chapter2.Developer;

import java.util.Scanner;

/** Вариант A, задание 7: первое число, состоящее только из различных цифр. */
public class DistinctDigitsNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько чисел: ");
        int n = scanner.nextInt();

        System.out.println("Введите " + n + " чисел:");
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = String.valueOf(scanner.nextLong());
        }

        String found = findFirstWithDistinctDigits(numbers);
        if (found == null) {
            System.out.println("Таких чисел нет");
        } else {
            System.out.println("Первое число из различных цифр: " + found);
        }

        Developer.printSignature();
    }

    static String findFirstWithDistinctDigits(String[] numbers) {
        for (String number : numbers) {
            if (hasDistinctDigits(number.toCharArray())) {
                return number;
            }
        }
        return null;
    }

    static boolean hasDistinctDigits(char[] chars) {
        boolean[] seen = new boolean[10];
        for (char c : chars) {
            if (c == '-') {
                continue;
            }
            int digit = c - '0';
            if (seen[digit]) {
                return false;
            }
            seen[digit] = true;
        }
        return true;
    }
}
