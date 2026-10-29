package com.epam.training.chapter1.varianta;

public class PasswordCheck {

    private static final String EXPECTED_PASSWORD = "epam2026";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Передайте пароль аргументом командной строки");
            return;
        }
        boolean matches = EXPECTED_PASSWORD.equals(args[0]);
        System.out.println(matches ? "Пароль верный" : "Пароль неверный");
    }
}
