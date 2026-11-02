package com.epam.training.chapter8.varianta;

public class TextCleaner {

    private static final String SAMPLE = "Привет,мир! В 2026-м году Java21 (и не только) -- это: сила...";

    public static void main(String[] args) {
        String text = args.length > 0 ? String.join(" ", args) : SAMPLE;
        System.out.println("Было:  " + text);
        System.out.println("Стало: " + clean(text));
    }

    static String clean(String text) {
        return text.replaceAll("[^\\p{L}]+", " ").strip();
    }
}
