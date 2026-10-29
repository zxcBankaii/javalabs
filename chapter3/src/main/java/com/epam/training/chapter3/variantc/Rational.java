package com.epam.training.chapter3.variantc;

public final class Rational implements Comparable<Rational> {

    public static final Rational ZERO = new Rational(0);

    private final long numerator;
    private final long denominator;

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            numerator = Math.negateExact(numerator);
            denominator = Math.negateExact(denominator);
        }
        long gcd = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Rational(long value) {
        this(value, 1);
    }

    public static Rational of(long numerator, long denominator) {
        return new Rational(numerator, denominator);
    }

    public Rational add(Rational other) {
        long top = Math.addExact(
                Math.multiplyExact(numerator, other.denominator),
                Math.multiplyExact(other.numerator, denominator));
        return new Rational(top, Math.multiplyExact(denominator, other.denominator));
    }

    public Rational subtract(Rational other) {
        return add(other.negate());
    }

    public Rational multiply(Rational other) {
        return new Rational(
                Math.multiplyExact(numerator, other.numerator),
                Math.multiplyExact(denominator, other.denominator));
    }

    public Rational divide(Rational other) {
        return multiply(new Rational(other.denominator, other.numerator));
    }

    public Rational negate() {
        return new Rational(-numerator, denominator);
    }

    public boolean isZero() {
        return numerator == 0;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a == 0 ? 1 : a;
    }

    @Override
    public int compareTo(Rational other) {
        return Long.compare(
                Math.multiplyExact(numerator, other.denominator),
                Math.multiplyExact(other.numerator, denominator));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Rational other
                && numerator == other.numerator
                && denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(numerator) + Long.hashCode(denominator);
    }

    @Override
    public String toString() {
        return denominator == 1 ? String.valueOf(numerator) : numerator + "/" + denominator;
    }
}
