package com.epam.training.chapter8.variantb.text;

import java.util.List;

public record Text(List<Paragraph> paragraphs) {

    public Text {
        paragraphs = List.copyOf(paragraphs);
    }

    public List<Word> words() {
        return paragraphs.stream()
                .flatMap(paragraph -> paragraph.sentences().stream())
                .flatMap(sentence -> sentence.words().stream())
                .toList();
    }
}
