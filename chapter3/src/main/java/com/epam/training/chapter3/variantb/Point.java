package com.epam.training.chapter3.variantb;

public record Point(double x, double y) {

    public double distanceTo(Point other) {
        return Math.hypot(x - other.x, y - other.y);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
