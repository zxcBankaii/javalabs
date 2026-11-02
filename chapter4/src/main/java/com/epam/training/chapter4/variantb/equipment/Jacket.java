package com.epam.training.chapter4.variantb.equipment;

import java.math.BigDecimal;

public class Jacket extends Equipment {

    private final boolean armored;

    public Jacket(String name, BigDecimal price, int weightGrams, boolean armored) {
        super(name, price, weightGrams);
        this.armored = armored;
    }

    @Override
    public String protectionInfo() {
        return armored ? "защита корпуса, со вставками" : "защита корпуса, без вставок";
    }
}
