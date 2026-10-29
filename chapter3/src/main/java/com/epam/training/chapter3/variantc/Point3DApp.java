package com.epam.training.chapter3.variantc;

public class Point3DApp {

    public static void main(String[] args) {
        Point3D a = new Point3D(Rational.of(1, 2), Rational.of(1, 3), Rational.of(1, 4));
        Point3D b = new Point3D(Rational.of(3, 2), Rational.of(4, 3), Rational.of(5, 4));
        Point3D c = new Point3D(Rational.of(5, 2), Rational.of(7, 3), Rational.of(9, 4));
        Point3D d = new Point3D(1, 2, 3);

        System.out.println("A = " + a + ", B = " + b + ", C = " + c + ", D = " + d);
        System.out.println();

        System.out.println("|AB|^2 = " + a.squaredDistanceTo(b));
        System.out.printf("|AB| = %.4f%n", a.distanceTo(b));
        System.out.printf("|AD| = %.4f%n", a.distanceTo(d));
        System.out.printf("|OA| = %.4f%n", a.distanceToOrigin());
        System.out.printf("|OD| = %.4f%n", d.distanceToOrigin());
        System.out.println();

        System.out.println("A, B, C на одной прямой: " + Point3D.areCollinear(a, b, c));
        System.out.println("A, B, D на одной прямой: " + Point3D.areCollinear(a, b, d));
    }
}
