package com.epam.training.chapter3.variantb;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TriangleApp {

    public static void main(String[] args) {
        double h = Math.sqrt(3);
        List<Triangle> triangles = List.of(
                new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, h)),
                new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, 2 * h)),
                new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)),
                new Triangle(new Point(0, 0), new Point(6, 0), new Point(0, 8)),
                new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, 5)),
                new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 3)),
                new Triangle(new Point(0, 0), new Point(5, 1), new Point(2, 7)),
                new Triangle(new Point(1, 1), new Point(4, 2), new Point(3, 6))
        );

        Map<TriangleType, List<Triangle>> groups = triangles.stream()
                .collect(Collectors.groupingBy(Triangle::type, () -> new EnumMap<>(TriangleType.class), Collectors.toList()));

        Comparator<Triangle> byArea = Comparator.comparingDouble(Triangle::area);
        Comparator<Triangle> byPerimeter = Comparator.comparingDouble(Triangle::perimeter);

        groups.forEach((type, items) -> {
            System.out.println(type.getTitle() + ": " + items.size() + " шт.");
            System.out.println("  max площадь:  " + items.stream().max(byArea).orElseThrow());
            System.out.println("  min площадь:  " + items.stream().min(byArea).orElseThrow());
            System.out.println("  max периметр: " + items.stream().max(byPerimeter).orElseThrow());
            System.out.println("  min периметр: " + items.stream().min(byPerimeter).orElseThrow());
            System.out.println();
        });
    }
}
