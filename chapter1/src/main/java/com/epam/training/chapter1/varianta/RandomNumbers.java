package com.epam.training.chapter1.varianta;

import java.util.Random;

public class RandomNumbers {

    private static final int DEFAULT_COUNT = 10;
    private static final int BOUND = 100;

    public static void main(String[] args) {
        int count = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_COUNT;
        int[] numbers = new Random().ints(count, 0, BOUND).toArray();

        System.out.println("В одну строку:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.println("Каждое с новой строки:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
