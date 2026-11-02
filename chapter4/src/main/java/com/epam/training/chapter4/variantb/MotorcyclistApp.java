package com.epam.training.chapter4.variantb;

import com.epam.training.chapter4.variantb.equipment.Boots;
import com.epam.training.chapter4.variantb.equipment.Equipment;
import com.epam.training.chapter4.variantb.equipment.Gloves;
import com.epam.training.chapter4.variantb.equipment.Helmet;
import com.epam.training.chapter4.variantb.equipment.Jacket;
import com.epam.training.chapter4.variantb.rider.Motorcyclist;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MotorcyclistApp {

    public static void main(String[] args) {
        Motorcyclist rider = new Motorcyclist("Алексей");
        rider.equip(new Helmet("Шлем Shark", new BigDecimal("450.00"), 1500, "ECE 22.06"));
        rider.equip(new Jacket("Куртка Dainese", new BigDecimal("780.50"), 2300, true));
        rider.equip(new Gloves("Перчатки Alpinestars", new BigDecimal("120.00"), 250, "кожа"));
        rider.equip(new Boots("Ботинки TCX", new BigDecimal("390.00"), 1800, 43));

        System.out.println("Мотоциклист: " + rider.getName());
        System.out.println("Стоимость экипировки: " + rider.totalCost() + " руб.");
        print("По весу:", rider.sortedByWeight());

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Цена от: ");
            BigDecimal min = new BigDecimal(scanner.next());
            System.out.print("Цена до: ");
            BigDecimal max = new BigDecimal(scanner.next());
            print("В диапазоне цен:", rider.findByPriceRange(min, max));
        } catch (NumberFormatException e) {
            System.out.println("Цена должна быть числом, дробная часть через точку");
        }
    }

    private static void print(String title, List<Equipment> items) {
        System.out.println(title);
        items.forEach(item -> System.out.println("  " + item));
    }
}
