package com.epam.training.chapter4.variantb.equipment;

import java.math.BigDecimal;

public abstract class Equipment {

    private final String name;
    private final BigDecimal price;
    private final int weightGrams;

    protected Equipment(String name, BigDecimal price, int weightGrams) {
        this.name = name;
        this.price = price;
        this.weightGrams = weightGrams;
    }

    public abstract String protectionInfo();

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, %s руб., %d г", name, protectionInfo(), price, weightGrams);
    }
}
