package com.epam.training.chapter8.variantb.text;

public record Symbol(char value) {

    private static final String VOWELS = "aeiouyаеёиоуыэюя";

    public boolean isLetter() {
        return Character.isLetter(value);
    }

    public boolean isVowel() {
        return VOWELS.indexOf(Character.toLowerCase(value)) >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
