package com.epam.training.chapter4.variantb.equipment;

import java.math.BigDecimal;

public class Boots extends Equipment {

    private final int size;

    public Boots(String name, BigDecimal price, int weightGrams, int size) {
        super(name, price, weightGrams);
        this.size = size;
    }

    @Override
    public String protectionInfo() {
        return "защита ног, размер " + size;
    }
}
