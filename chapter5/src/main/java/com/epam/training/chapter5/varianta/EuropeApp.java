package com.epam.training.chapter5.varianta;

import java.util.List;

public class EuropeApp {

    public static void main(String[] args) {
        Europe europe = new Europe(List.of("ФРГ", "ГДР", "Чехословакия", "Франция", "Польша"));

        europe.recordChange(1993, "Распад Чехословакии", List.of("Чехословакия"), List.of("Чехия", "Словакия"));
        europe.recordChange(1990, "Объединение Германии", List.of("ФРГ", "ГДР"), List.of("Германия"));

        System.out.println("История изменений:");
        europe.getHistory().forEach(change -> System.out.println("  " + change));
        System.out.println("Сейчас государств: " + europe.getStateCount());
        System.out.println(europe.getStates());

        try {
            europe.recordChange(2000, "Несуществующее изменение", List.of("Атлантида"), List.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
