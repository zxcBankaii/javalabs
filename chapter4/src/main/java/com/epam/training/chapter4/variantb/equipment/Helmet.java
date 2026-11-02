package com.epam.training.chapter4.variantb.equipment;

import java.math.BigDecimal;

public class Helmet extends Equipment {

    private final String certificate;

    public Helmet(String name, BigDecimal price, int weightGrams, String certificate) {
        super(name, price, weightGrams);
        this.certificate = certificate;
    }

    @Override
    public String protectionInfo() {
        return "защита головы, сертификат " + certificate;
    }
}
