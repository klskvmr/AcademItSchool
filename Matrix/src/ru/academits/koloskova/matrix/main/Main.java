package ru.academits.koloskova.matrix.main;

import ru.academits.koloskova.matrix.Matrix;
import ru.academits.koloskova.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 3);

        //проверка копирования
        Matrix matrix1 = new Matrix(matrix);
        System.out.println("Matrix1: " + matrix1.toString());
        System.out.println();

        double[][] testMatrixArray = new double[4][4];
        testMatrixArray[0] = new double[]{1, -2, 3, 1};
        testMatrixArray[1] = new double[]{3, 0, 1, 5};
        testMatrixArray[2] = new double[]{1, 3, 4, -2};
        testMatrixArray[3] = new double[]{4, 2, 2, 1};
        Matrix matrix2 = new Matrix(testMatrixArray);

        //проверка конструктора из двумерного массива
        testMatrixArray[0] = new double[]{2, -2, 3, 1};
        testMatrixArray[1] = new double[]{3, 0, 1, 5};
        testMatrixArray[2] = new double[]{1, 3, 4, -2};
        testMatrixArray[3] = new double[]{4, 2, 2, 1};
        Matrix testMatrix = new Matrix(testMatrixArray);
        System.out.println("TEST_MATRIX: " + testMatrix.toString());

        System.out.println("Sum: " + Matrix.sum(testMatrix, matrix2).toString());
        System.out.println("Difference: " + Matrix.difference(testMatrix, matrix2).toString());

        System.out.println("Determinant: " + testMatrix.getDeterminant());
        testMatrix.multiplicationByVector(new Vector(new double[]{1, 1, 1, 1}));
        System.out.println("TEST_MATRIX x vector{1, 1, 1, 1}: " + testMatrix);
        System.out.println();

        //проверка конструктора из массива векторов-строк
        Vector[] rows = new Vector[2];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(new double[]{i, i, i, 2});
        }

        Matrix matrix3 = new Matrix(rows);
        System.out.println("Matrix3: " + matrix3.toString());

        System.out.println("Matrix3 size: rows = " + matrix3.getRowsAmount() +
                ", columns = " + matrix3.getColumnsAmount());

        System.out.println("Row: " + matrix3.getRow(1).toString());
        System.out.println("Column: " + matrix3.getColumn(0));

        matrix3.setRow(0, new Vector(new double[]{5, 5, 5, 5}));
        System.out.println("Matrix3 after set row: " + matrix3.toString());

        matrix3.transpose();
        System.out.println("Transpose Matrix3: " + matrix3.toString());
    }
}
