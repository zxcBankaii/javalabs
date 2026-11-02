package com.epam.training.chapter4.variantb.rider;

import com.epam.training.chapter4.variantb.equipment.Equipment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Motorcyclist {

    private final String name;
    private final List<Equipment> equipment = new ArrayList<>();

    public Motorcyclist(String name) {
        this.name = name;
    }

    public void equip(Equipment item) {
        equipment.add(item);
    }

    public BigDecimal totalCost() {
        return equipment.stream()
                .map(Equipment::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Equipment> sortedByWeight() {
        return equipment.stream()
                .sorted(Comparator.comparingInt(Equipment::getWeightGrams))
                .toList();
    }

    public List<Equipment> findByPriceRange(BigDecimal min, BigDecimal max) {
        return equipment.stream()
                .filter(item -> item.getPrice().compareTo(min) >= 0 && item.getPrice().compareTo(max) <= 0)
                .toList();
    }

    public String getName() {
        return name;
    }
}
