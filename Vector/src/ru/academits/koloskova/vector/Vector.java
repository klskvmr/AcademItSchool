package ru.academits.koloskova.vector;

public class Vector {
    private int n;
    private double[] valuesArray;

    public Vector() {

    }

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n can’t be <= 0");
        }
        this.n = n;

        double[] valuesArray = new double[n];
        for (int i = 0; i < n; i++) {
            valuesArray[i] = 0;
        }
        this.valuesArray = valuesArray;
    }

    public Vector(Vector vector) {
        n = vector.n;

        valuesArray = vector.valuesArray;
    }

    public Vector(double[] valuesArray) {
        if (valuesArray.length == 0) {
            throw new ArrayIndexOutOfBoundsException("n can’t be = 0");
        }
        n = valuesArray.length;

        this.valuesArray = valuesArray;
    }

    public Vector(int n, double[] array) {

    }

    public int getN() {
        return n;
    }

    public double[] getValluesArray() {
        return valuesArray;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setValluesArray(double[] valluesArray) {
        this.valuesArray = valluesArray;
    }
}
