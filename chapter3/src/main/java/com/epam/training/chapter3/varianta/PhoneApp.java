package com.epam.training.chapter3.varianta;

import java.math.BigDecimal;
import java.util.List;

public class PhoneApp {

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory(
                new Phone(1, "Сидоров", "Пётр", "Иванович", "ул. Ленина, 5", "4276 1111 2222 3333",
                        new BigDecimal("150.00"), new BigDecimal("0.00"), 320, 0),
                new Phone(2, "Андреев", "Олег", "Сергеевич", "пр. Мира, 12", "4276 4444 5555 6666",
                        new BigDecimal("80.50"), new BigDecimal("20.00"), 45, 12),
                new Phone(3, "Козлова", "Анна", "Викторовна", "ул. Садовая, 3", "5536 7777 8888 9999",
                        new BigDecimal("0.00"), new BigDecimal("310.00"), 610, 95),
                new Phone(4, "Андреев", "Игорь", "Павлович", "ул. Гагарина, 40", "2200 1234 5678 9012",
                        new BigDecimal("12.00"), new BigDecimal("5.00"), 120, 0)
        );

        int minutesLimit = 100;
        print("Внутригородские разговоры дольше " + minutesLimit + " мин:",
                directory.withCityCallsLongerThan(minutesLimit));
        print("Пользовались междугородной связью:", directory.withIntercityCalls());
        print("В алфавитном порядке:", directory.sortedByName());
    }

    private static void print(String title, List<Phone> phones) {
        System.out.println(title);
        phones.forEach(phone -> System.out.println("  " + phone));
        System.out.println();
    }
}
