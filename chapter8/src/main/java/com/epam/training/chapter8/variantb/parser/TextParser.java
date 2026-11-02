package com.epam.training.chapter8.variantb.parser;

import com.epam.training.chapter8.variantb.text.Lexeme;
import com.epam.training.chapter8.variantb.text.Paragraph;
import com.epam.training.chapter8.variantb.text.PunctuationMark;
import com.epam.training.chapter8.variantb.text.Sentence;
import com.epam.training.chapter8.variantb.text.Symbol;
import com.epam.training.chapter8.variantb.text.Text;
import com.epam.training.chapter8.variantb.text.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final Pattern LEXEME = Pattern.compile("[\\p{L}\\p{N}]+|\\S");

    public Text parse(String source) {
        String normalized = source.replaceAll("[ \\t]+", " ").strip();
        List<Paragraph> paragraphs = Arrays.stream(normalized.split("\\R+"))
                .map(this::parseParagraph)
                .toList();
        return new Text(paragraphs);
    }

    private Paragraph parseParagraph(String paragraph) {
        List<Sentence> sentences = Arrays.stream(paragraph.strip().split("(?<=[.!?])\\s+"))
                .map(this::parseSentence)
                .toList();
        return new Paragraph(sentences);
    }

    private Sentence parseSentence(String sentence) {
        List<Lexeme> lexemes = new ArrayList<>();
        Matcher matcher = LEXEME.matcher(sentence);
        while (matcher.find()) {
            lexemes.add(parseLexeme(matcher.group()));
        }
        return new Sentence(lexemes);
    }

    private Lexeme parseLexeme(String token) {
        List<Symbol> symbols = token.chars()
                .mapToObj(c -> new Symbol((char) c))
                .toList();
        char first = token.charAt(0);
        if (Character.isLetterOrDigit(first)) {
            return new Word(symbols);
        }
        return new PunctuationMark(symbols.get(0));
    }
}
