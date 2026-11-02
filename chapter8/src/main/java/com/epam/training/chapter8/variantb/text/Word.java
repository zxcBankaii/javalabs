package com.epam.training.chapter8.variantb.text;

import java.util.List;
import java.util.stream.Collectors;

public record Word(List<Symbol> symbols) implements Lexeme {

    public Word {
        symbols = List.copyOf(symbols);
    }

    public double vowelShare() {
        long letters = symbols.stream().filter(Symbol::isLetter).count();
        if (letters == 0) {
            return 0;
        }
        long vowels = symbols.stream().filter(Symbol::isVowel).count();
        return (double) vowels / letters;
    }

    @Override
    public String toString() {
        return symbols.stream().map(Symbol::toString).collect(Collectors.joining());
    }
}
