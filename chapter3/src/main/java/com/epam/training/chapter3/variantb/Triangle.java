package com.epam.training.chapter3.variantb;

import java.util.Arrays;

public class Triangle {

    private static final double EPSILON = 1e-9;

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (doubledArea(a, b, c) < EPSILON) {
            throw new IllegalArgumentException("Точки лежат на одной прямой: " + a + ", " + b + ", " + c);
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() {
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }

    public double area() {
        return doubledArea(a, b, c) / 2;
    }

    public TriangleType type() {
        double[] sides = {a.distanceTo(b), b.distanceTo(c), c.distanceTo(a)};
        Arrays.sort(sides);

        if (equal(sides[0], sides[2])) {
            return TriangleType.EQUILATERAL;
        }
        if (equal(sides[0] * sides[0] + sides[1] * sides[1], sides[2] * sides[2])) {
            return TriangleType.RIGHT;
        }
        if (equal(sides[0], sides[1]) || equal(sides[1], sides[2])) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.ARBITRARY;
    }

    private static double doubledArea(Point a, Point b, Point c) {
        return Math.abs((b.x() - a.x()) * (c.y() - a.y()) - (c.x() - a.x()) * (b.y() - a.y()));
    }

    private static boolean equal(double x, double y) {
        return Math.abs(x - y) < EPSILON * Math.max(1, Math.max(Math.abs(x), Math.abs(y)));
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, S = %.2f, P = %.2f", a, b, c, area(), perimeter());
    }
}
