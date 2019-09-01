package ru.academits.koloskova.matrix;

import ru.academits.koloskova.vector.Vector;

import java.util.Arrays;

//В конструкторах постараться добить данные нулями до максимальной длины.??????
//exception
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

        int columnsAmount = matrix.rows[0].getSize();

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(columnsAmount);
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
        for (int i = 0; i < getRowsAmount(); i++) {
            rows[0].multiplicationByScalar(number);
        }
    }

    public double getDeterminant() {
        return 1;
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

    public void sum() {

    }

    public void difference() {
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
