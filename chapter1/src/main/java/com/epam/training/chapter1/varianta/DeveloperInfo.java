package com.epam.training.chapter1.varianta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeveloperInfo {

    private static final String DEVELOPER = "Иванов";
    private static final LocalDateTime RECEIVED_AT = LocalDateTime.of(2026, 10, 29, 18, 0);
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {
        System.out.println("Разработчик: " + DEVELOPER);
        System.out.println("Задание получено: " + RECEIVED_AT.format(FORMAT));
        System.out.println("Задание сдано: " + LocalDateTime.now().format(FORMAT));
    }
}
