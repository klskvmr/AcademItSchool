package ru.academits.koloskova.vector.main;

import ru.academits.koloskova.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5};

        Vector vector = new Vector(array);
        Vector vector1 = new Vector(9, array);
        Vector vector2 = new Vector(vector1);

        System.out.println(Arrays.toString(vector2.getVectorComponents()));
        System.out.println(vector1.equals(vector2));

        System.out.println(vector1.hashCode() == vector2.hashCode());
        System.out.println(vector.hashCode() == vector2.hashCode());

        vector2.getSpread();
        System.out.println(Arrays.toString(vector2.getVectorComponents()));

        System.out.println(vector.getComponentByIndex(2));

        vector2.multiplyByScalar(-1);
        System.out.println(vector2);

        double[] a = {1, 2, 3, 4};
        double[] b = {1, 1, 1, 1, 5, 5, 5, 5};
        Vector testSum1 = new Vector(a);
        Vector testSum2 = new Vector(b);
        System.out.println(Vector.getScalarProduct(testSum1, testSum2));
    }
}
