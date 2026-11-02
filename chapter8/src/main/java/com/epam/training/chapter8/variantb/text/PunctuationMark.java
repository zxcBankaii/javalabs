package com.epam.training.chapter8.variantb.text;

public record PunctuationMark(Symbol symbol) implements Lexeme {

    @Override
    public String toString() {
        return symbol.toString();
    }
}
