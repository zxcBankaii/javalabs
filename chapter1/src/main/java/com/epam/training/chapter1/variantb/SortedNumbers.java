package com.epam.training.chapter1.variantb;

import java.util.Arrays;
import java.util.Scanner;

public class SortedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько чисел: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] ascending = numbers.clone();
        Arrays.sort(ascending);
        int[] descending = reversed(ascending);

        System.out.println("По возрастанию: " + Arrays.toString(ascending));
        System.out.println("По убыванию:    " + Arrays.toString(descending));
    }

    private static int[] reversed(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }
}
