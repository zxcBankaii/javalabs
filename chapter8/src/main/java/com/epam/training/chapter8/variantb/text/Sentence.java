package com.epam.training.chapter8.variantb.text;

import java.util.List;

public record Sentence(List<Lexeme> lexemes) {

    public Sentence {
        lexemes = List.copyOf(lexemes);
    }

    public List<Word> words() {
        return lexemes.stream()
                .filter(Word.class::isInstance)
                .map(Word.class::cast)
                .toList();
    }
}
