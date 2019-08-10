package ru.academits.koloskova;

import java.util.Arrays;

public class Vector {
    private double[] vectorComponents;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Vector length can't be less than or equal to 0");
        }

        vectorComponents = new double[n];
        for (int i = 0; i < n - 1; i++) {
            vectorComponents[i] = 0;
        }
    }

    public Vector(Vector vector) {
        vectorComponents = vector.vectorComponents;
    }

    public Vector(double[] vectorComponents) {
        if (vectorComponents.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Vector length can't be equal to 0");
        }
        this.vectorComponents = vectorComponents;
    }

    public Vector(int n, double[] vectorComponents) {
        if (n <= 0) {
            throw new IllegalArgumentException("Vector length can't be less than or equal to 0");
        } else if (n < vectorComponents.length) {
            throw new IllegalArgumentException("Vector length can't be less than input array length");
        }

        this.vectorComponents = new double[n];
        for (int i = 0; i < n - 1; i++) {
            if (i < vectorComponents.length) {
                this.vectorComponents[i] = vectorComponents[i];
            } else {
                this.vectorComponents[i] = 0;
            }
        }
    }

    public double[] getVectorComponents() {
        return vectorComponents;
    }

    public void setVectorComponents(double[] vectorComponents) {
        this.vectorComponents = vectorComponents;
    }

    public int getSize() {
        return vectorComponents.length;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("{");
        for (double value : vectorComponents) {
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

        return vectorComponents.length == vector.vectorComponents.length &&
                Arrays.equals(vectorComponents, vector.vectorComponents);
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + vectorComponents.length;
        hash = prime * hash + Arrays.hashCode(vectorComponents);

        return hash;
    }

    public void getSum(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vectorComponents.length; i++) {
            if (i >= vector.vectorComponents.length) {
                continue;
            }

            vectorComponents[i] += vector.vectorComponents[i];
        }
    }

    public void getDifference(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vectorComponents.length; i++) {
            if (i >= vector.vectorComponents.length) {
                continue;
            }

            vectorComponents[i] -= vector.vectorComponents[i];
        }
    }

    public void multiplyByScalar(int number) {
        for (int i = 0; i < getSize(); i++) {
            if (vectorComponents[i] == 0) {
                continue;
            }
            vectorComponents[i] *= number;
        }
    }

    public void getSpread() {
        for (int i = 0; i < getSize(); i++) {
            if (vectorComponents[i] == 0) {
                continue;
            }
            vectorComponents[i] *= -1;
        }
    }

    public double getComponentByIndex(int index) {
        if (index < 0 || index >= vectorComponents.length) {
            throw new IllegalArgumentException("Current index doesn't exist!!");
        }

        return vectorComponents[index];
    }

    public void setComponentByIndex(int index, double number) {
        if (index < 0 || index >= vectorComponents.length) {
            throw new IllegalArgumentException("Current index doesn't exist!!");
        }

        vectorComponents[index] = number;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector sum = new Vector(vector1);
        sum.getSum(vector2);

        return sum;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector difference = new Vector(vector1);
        difference.getDifference(vector2);

        return difference;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        if (vector.vectorComponents.length < vector2.vectorComponents.length) {
            vector.vectorComponents = Arrays.copyOf(vector.vectorComponents, vector2.vectorComponents.length);
        }

        double scalar = 0;
        for (int i = 0; i < vector1.vectorComponents.length; i++) {
            scalar += vector.vectorComponents[i] * vector2.vectorComponents[i];
        }

        return scalar;
    }
}
