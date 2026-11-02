package com.epam.training.chapter7.varianta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentApp {

    private static final double MIN_GRADE = 8;

    public static void main(String[] args) {
        Student[] students = {
                new Student("Мария", 20, 9.1),
                new Student("Дмитрий", 19, 7.5),
                new Student("Анна", 21, 8.4),
                new Student("Борис", 22, 8.0),
                new Student("Вера", 19, 9.8)
        };

        System.out.println("Оценка выше " + MIN_GRADE + ", по имени:");
        excellentByName(students).forEach(System.out::println);
    }

    static List<Student> excellentByName(Student[] students) {
        return Arrays.stream(students)
                .filter(student -> student.grade() > MIN_GRADE)
                .sorted(Comparator.comparing(Student::name))
                .toList();
    }
}
