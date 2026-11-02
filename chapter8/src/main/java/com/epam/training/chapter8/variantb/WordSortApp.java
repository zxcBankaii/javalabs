package com.epam.training.chapter8.variantb;

import com.epam.training.chapter8.variantb.parser.TextParser;
import com.epam.training.chapter8.variantb.text.Text;
import com.epam.training.chapter8.variantb.text.Word;

import java.util.Comparator;
import java.util.List;

public class WordSortApp {

    private static final String TEXTBOOK = """
            Класс   описывает состояние и поведение объекта.\tКонструктор создаёт экземпляр!
            Что такое интерфейс? Это контракт, который реализует класс.

            Метод main запускает программу, а Java 21 компилирует её.
            """;

    public static void main(String[] args) {
        Text text = new TextParser().parse(TEXTBOOK);
        for (Word word : sortByVowelShare(text)) {
            System.out.printf("%-14s %.2f%n", word, word.vowelShare());
        }
    }

    static List<Word> sortByVowelShare(Text text) {
        return text.words().stream()
                .sorted(Comparator.comparingDouble(Word::vowelShare)
                        .thenComparing(Word::toString, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }
}
