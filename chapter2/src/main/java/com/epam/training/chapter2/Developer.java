package com.epam.training.chapter2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Подпись разработчика, которая по условию выводится в конце каждой задачи главы. */
public final class Developer {

    private static final String NAME = "Иванов";
    private static final LocalDateTime RECEIVED_AT = LocalDateTime.of(2026, 10, 29, 18, 0);
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private Developer() {
    }

    public static void printSignature() {
        System.out.println();
        System.out.println("Разработчик: " + NAME);
        System.out.println("Задание получено: " + RECEIVED_AT.format(FORMAT));
        System.out.println("Задание сдано: " + LocalDateTime.now().format(FORMAT));
    }
}
