package com.epam.training.chapter8.variantc;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FileMask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Маска: ");
        String mask = scanner.nextLine();

        System.out.println(matches(fileName, mask) ? "Подходит" : "Не подходит");
    }

    static boolean matches(String fileName, String mask) {
        return Pattern.matches(toRegex(mask), fileName);
    }

    private static String toRegex(String mask) {
        StringBuilder regex = new StringBuilder();
        for (char c : mask.toCharArray()) {
            switch (c) {
                case '*' -> regex.append(".*");
                case '?' -> regex.append('.');
                default -> regex.append(Pattern.quote(String.valueOf(c)));
            }
        }
        return regex.toString();
    }
}
