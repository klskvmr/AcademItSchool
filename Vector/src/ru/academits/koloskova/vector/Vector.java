package ru.academits.koloskova.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Vector length can't be less than or equal to 0.");
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Vector length can't be equal to 0.");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int length, double[] components) {
        if (length <= 0) {
            throw new IllegalArgumentException("Vector length can't be less than or equal to 0.");
        }

        this.components = Arrays.copyOf(components, length);
    }

    public int getLength() {
        return components.length;
    }

    public double getElement(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Element with this index doesn't exists.");
        }

        return components[index];
    }

    public void setElement(int index, double number) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Element with this index doesn't exists.");
        }

        components[index] = number;
    }

    public void sum(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void difference(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplicationByScalar(int number) {
        for (int i = 0; i < getLength(); i++) {
            if (components[i] == 0) {
                continue;
            }
            components[i] *= number;
        }
    }

    public void revert() {
        multiplicationByScalar(-1);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.sum(vector2);

        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.difference(vector2);

        return vector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.components.length, vector2.components.length);
        double scalar = 0;

        for (int i = 0; i < minLength; i++) {
            scalar += vector1.components[i] * vector2.components[i];
        }

        return scalar;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");

        for (double value : components) {
            string.append(value).append(", ");
        }
        string.delete(string.length() - 2, string.length()).append("}");

        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }
}