package ru.academits.koloskova.matrix;

import ru.academits.koloskova.vector.Vector;

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
            rows[i] = new Vector(matrix.getRow(i));
        }
    }

    public Matrix(double[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("The number of columns or rows cannot be equal to 0.");
        }

        rows = new Vector[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            rows[i] = new Vector(matrix[i]);
        }
    }

    public Matrix(Vector[] rows) {
        this.rows = rows;

        for (int i = 0; i < rows.length; i++) {
            this.rows[i] = new Vector(rows[i]);
        }
    }

    public int getRowsAmount() {
        return rows.length;
    }

    public int getColumnsAmount() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if ((index < 0) || (index >= getRowsAmount())) {
            throw new IndexOutOfBoundsException("Row with this index doesn't exists");
        }

        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector row) {
        if ((index < 0) || (index >= getRowsAmount())) {
            throw new IndexOutOfBoundsException("Row with this index doesn't exists");
        }
        if (row.getSize() != getColumnsAmount()) {
            throw new IllegalArgumentException("the dimension of the given row must correspond to the size of the row being changed");
        }

        rows[index] = new Vector(row);
    }

    public Vector getColumn(int index) {
        if ((index < 0) || (index >= getColumnsAmount())) {
            throw new IndexOutOfBoundsException("Column with this index doesn't exists");
        }

        int columnLength = getRowsAmount();
        Vector column = new Vector(columnLength);

        for (int i = 0; i < columnLength; i++) {
            column.setElement(i, rows[i].getElement(index));
        }

        return column;
    }

    public void transpose() {
        Vector[] newRows = new Vector[getColumnsAmount()];

        for (int i = 0; i < getColumnsAmount(); i++) {
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
        if (getRowsAmount() != getColumnsAmount()) {
            throw new IllegalArgumentException("The determinant can only be calculated for a square matrix");
        }

        int matrixSize = getRowsAmount();
        double[][] matrix = new double[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = rows[i].getElement(j);
            }
        }

        return calculateDeterminant(matrix);
    }

    public void multiplicationByVector(Vector vector) {
        if (vector.getSize() > getColumnsAmount()) {
            throw new IllegalArgumentException("The length of the vector must match the number of matrix columns");
        }

        Vector[] result = new Vector[getRowsAmount()];
        for (int i = 0; i < getRowsAmount(); i++) {
            result[i] = new Vector(1);
            result[i].setElement(0, Vector.getScalarProduct(rows[i], vector));
        }

        rows = result;
    }

    public static Matrix sum(Matrix matrix1, Matrix matrix2) {
        if ((matrix1.getRowsAmount() != matrix2.getRowsAmount())||(matrix1.getColumnsAmount() != matrix2.getColumnsAmount())) {
            throw new IllegalArgumentException("Matrices must be of the same dimension!");
        }

        Matrix sum = new Matrix(matrix1);

        for (int i = 0; i < sum.getRowsAmount(); i++){
            for (int j = 0; j < sum.getColumnsAmount(); j++){
                sum.rows[i].setElement(j, sum.rows[i].getElement(j) + matrix2.rows[i].getElement(j));
            }
        }
        return sum;
    }

    public static Matrix difference(Matrix matrix, Matrix subtractedMatrix) {
        if ((matrix.getRowsAmount() != subtractedMatrix.getRowsAmount())||(matrix.getColumnsAmount() != subtractedMatrix.getColumnsAmount())) {
            throw new IllegalArgumentException("Matrices must be of the same dimension!");
        }

        Matrix difference = new Matrix(matrix);

        for (int i = 0; i < difference.getRowsAmount(); i++){
            for (int j = 0; j < difference.getColumnsAmount(); j++){
                difference.rows[i].setElement(j, matrix.rows[i].getElement(j) - subtractedMatrix.rows[i].getElement(j));
            }
        }
        return difference;
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
