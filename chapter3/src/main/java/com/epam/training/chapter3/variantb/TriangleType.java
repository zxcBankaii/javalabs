package com.epam.training.chapter3.variantb;

public enum TriangleType {
    EQUILATERAL("равносторонний"),
    RIGHT("прямоугольный"),
    ISOSCELES("равнобедренный"),
    ARBITRARY("произвольный");

    private final String title;

    TriangleType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
