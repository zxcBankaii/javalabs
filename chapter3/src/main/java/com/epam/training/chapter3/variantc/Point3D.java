package com.epam.training.chapter3.variantc;

import java.util.Objects;

public final class Point3D {

    public static final Point3D ORIGIN = new Point3D(0, 0, 0);

    private final Rational x;
    private final Rational y;
    private final Rational z;

    public Point3D(Rational x, Rational y, Rational z) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
        this.z = Objects.requireNonNull(z);
    }

    public Point3D(long x, long y, long z) {
        this(new Rational(x), new Rational(y), new Rational(z));
    }

    public Rational squaredDistanceTo(Point3D other) {
        Rational dx = x.subtract(other.x);
        Rational dy = y.subtract(other.y);
        Rational dz = z.subtract(other.z);
        return dx.multiply(dx).add(dy.multiply(dy)).add(dz.multiply(dz));
    }

    public double distanceTo(Point3D other) {
        return Math.sqrt(squaredDistanceTo(other).toDouble());
    }

    public double distanceToOrigin() {
        return distanceTo(ORIGIN);
    }

    public static boolean areCollinear(Point3D a, Point3D b, Point3D c) {
        Rational abX = b.x.subtract(a.x);
        Rational abY = b.y.subtract(a.y);
        Rational abZ = b.z.subtract(a.z);
        Rational acX = c.x.subtract(a.x);
        Rational acY = c.y.subtract(a.y);
        Rational acZ = c.z.subtract(a.z);

        return abY.multiply(acZ).subtract(abZ.multiply(acY)).isZero()
                && abZ.multiply(acX).subtract(abX.multiply(acZ)).isZero()
                && abX.multiply(acY).subtract(abY.multiply(acX)).isZero();
    }

    public Rational getX() {
        return x;
    }

    public Rational getY() {
        return y;
    }

    public Rational getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point3D other && x.equals(other.x) && y.equals(other.y) && z.equals(other.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + ")";
    }
}
