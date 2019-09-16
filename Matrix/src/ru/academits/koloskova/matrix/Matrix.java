package ru.academits.koloskova.matrix;

import ru.academits.koloskova.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowAmount, int columnsAmount) {
        if (rowAmount <= 0 || columnsAmount <= 0) {
            throw new IllegalArgumentException("The number of columns or rows cannot be less than or equal to 0.");
        }

        rows = new Vector[rowAmount];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(columnsAmount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] matrix) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("The number of rows cannot be equal to 0.");
        }

        rows = new Vector[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            rows[i] = new Vector(matrix[i]);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows.length == 0) {
            throw new IllegalArgumentException("The number of rows cannot be equal to 0.");
        }

        this.rows = rows;
    }

    public int getRowsAmount() {
        return rows.length;
    }

    public int getColumnsAmount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if ((index < 0) || (index >= this.rows.length)) {
            throw new IndexOutOfBoundsException("Row with this index doesn't exists");
        }

        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector row) {
        if ((index < 0) || (index >= this.rows.length)) {
            throw new IndexOutOfBoundsException("Row with this index doesn't exists");
        }
        if (row.getSize() != this.rows[0].getSize()) {
            throw new IllegalArgumentException("the dimension of the given row must correspond to the size of the row being changed");
        }

        rows[index] = new Vector(row);
    }

    public Vector getColumn(int index) {
        if ((index < 0) || (index >= this.rows[0].getSize())) {
            throw new IndexOutOfBoundsException("Column with this index doesn't exists");
        }

        int columnLength = rows.length;
        Vector column = new Vector(columnLength);

        for (int i = 0; i < columnLength; i++) {
            column.setElement(i, rows[i].getElement(index));
        }

        return column;
    }

    public void transpose() {
        int newRowsAmount = this.rows[0].getSize();

        Vector[] newRows = new Vector[newRowsAmount];

        for (int i = 0; i < newRowsAmount; i++) {
            newRows[i] = getColumn(i);
        }

        rows = newRows;
    }

    public void multiplicationByScalar(int number) {
        for (Vector row : rows) {
            row.multiplicationByScalar(number);
        }
    }

    private double[][] getMinor(int currentColumn, double[][] matrix) {
        int minorSize = matrix.length - 1;
        double[][] minor = new double[minorSize][minorSize];

        int skipRow = 1;

        for (int i = 0; i < minorSize; i++) {
            int skipColumn = 0;

            for (int j = 0; j < minorSize; j++) {
                if (j == currentColumn) {
                    skipColumn = 1;
                }

                minor[i][j] = matrix[i + skipRow][j + skipColumn];
            }
        }

        return minor;
    }

    private double calculateDeterminant(double[][] matrix) {
        int matrixSize = matrix.length;

        if (matrixSize == 1) {
            return matrix[0][0];
        }

        if (matrixSize == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }

        double determinant = 0;
        int decompositionString = 0;

        for (int j = 0; j < matrixSize; j++) {
            determinant += Math.pow(-1, j) * matrix[decompositionString][j] * calculateDeterminant(getMinor(j, matrix));
        }

        return determinant;
    }

    public double getDeterminant() {
        if (this.rows.length != this.rows[0].getSize()) {
            throw new IllegalArgumentException("The determinant can only be calculated for a square matrix");
        }

        int matrixSize = this.rows.length;
        double[][] matrix = new double[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = rows[i].getElement(j);
            }
        }

        return calculateDeterminant(matrix);
    }

    public Vector multiply(Vector vector) {
        if (vector.getSize() == 0) {
            throw new IllegalArgumentException("The length of the vector can't be equal 0!");
        }

        if (vector.getSize() > rows[0].getSize()) {
            throw new IllegalArgumentException("The length of the vector must match the number of matrix columns");
        }

        double[] components = new double[rows.length];

        for (int i = 0; i < vector.getSize(); i++) {
            components[i] = vector.getElement(i);
        }
        vector = new Vector(components);

        Vector result = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            result.setElement(i, Vector.getScalarProduct(rows[i], vector));
        }

        return result;
    }

    public void sum(Matrix matrix) {
        if ((rows.length != matrix.rows.length) || (rows[0].getSize() != matrix.rows[0].getSize())) {
            throw new IllegalArgumentException("Matrices must be of the same dimension!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].sum(matrix.rows[i]);
        }
    }

    public void difference(Matrix matrix) {
        if ((rows.length != matrix.rows.length) || (rows[0].getSize() != matrix.rows[0].getSize())) {
            throw new IllegalArgumentException("Matrices must be of the same dimension!");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].difference(matrix.rows[i]);
        }
    }

    public static Matrix sum(Matrix matrix, Matrix matrix1) {
        if ((matrix.rows.length != matrix1.rows.length) || (matrix.rows[0].getSize() != matrix1.rows[0].getSize())) {
            throw new IllegalArgumentException("Matrices must be of the same dimension!");
        }

        Matrix sum = new Matrix(matrix);

        for (int i = 0; i < sum.rows.length; i++) {
            sum.rows[i] = Vector.getSum(matrix.rows[i], matrix1.rows[i]);
        }

        return sum;
    }

    public static Matrix difference(Matrix matrix, Matrix matrix1) {
        if ((matrix.rows.length != matrix1.rows.length) || (matrix.rows[0].getSize() != matrix1.rows[0].getSize())) {
            throw new IllegalArgumentException("Matrices must be of the same dimension!");
        }

        Matrix difference = new Matrix(matrix);

        for (int i = 0; i < difference.rows.length; i++) {
            difference.rows[i] = Vector.getDifference(matrix.rows[i], matrix1.rows[i]);
        }

        return difference;
    }

    public static Matrix multiply(Matrix matrix, Matrix matrix1) {
        if ((matrix.rows[0].getSize() != matrix1.rows.length)) {
            throw new IllegalArgumentException("Matrices are not consistent! " +
                    "The number of columns of the first matrix should be equal to the number of rows of the second");
        }

        int rowsAmount = matrix.rows.length;
        int columnsAmount = matrix1.rows[0].getSize();

        Matrix result = new Matrix(rowsAmount, columnsAmount);

        for (int i = 0; i < rowsAmount; i++) {
            for (int j = 0; j < columnsAmount; j++) {
                result.rows[i].setElement(j, Vector.getScalarProduct(matrix.rows[i], matrix1.getColumn(j)));
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Vector vector : rows) {
            stringBuilder.append(vector.toString()).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}