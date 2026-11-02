package com.epam.training.chapter4.variantb.equipment;

import java.math.BigDecimal;

public class Gloves extends Equipment {

    private final String material;

    public Gloves(String name, BigDecimal price, int weightGrams, String material) {
        super(name, price, weightGrams);
        this.material = material;
    }

    @Override
    public String protectionInfo() {
        return "защита рук, материал " + material;
    }
}
