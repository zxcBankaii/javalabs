package com.epam.training.chapter8.variantb.text;

import java.util.List;

public record Paragraph(List<Sentence> sentences) {

    public Paragraph {
        sentences = List.copyOf(sentences);
    }
}
