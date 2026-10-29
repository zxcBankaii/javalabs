package com.epam.training.chapter2.variantc;

import com.epam.training.chapter2.Developer;

import java.util.Random;
import java.util.Scanner;

/** Вариант C, задание 7: поворот матрицы на 90, 180 и 270 градусов против часовой стрелки. */
public class MatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Размерность матрицы n: ");
        int n = scanner.nextInt();

        int[][] matrix = randomMatrix(n, new Random());
        print("Исходная матрица", matrix);

        int[][] rotated = matrix;
        for (int degrees = 90; degrees <= 270; degrees += 90) {
            rotated = rotateLeft(rotated);
            print("Поворот на " + degrees, rotated);
        }

        Developer.printSignature();
    }

    static int[][] randomMatrix(int n, Random random) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(-n, n + 1);
            }
        }
        return matrix;
    }

    static int[][] rotateLeft(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[n - 1 - j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static void print(String title, int[][] matrix) {
        System.out.println(title + ":");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        System.out.println();
    }
}
