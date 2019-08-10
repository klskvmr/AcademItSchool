package ru.academits.koloskova.main;

import ru.academits.koloskova.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5};

        Vector vector = new Vector(array);
        System.out.println("Vector: " + vector.toString());
        Vector vector1 = new Vector(7, array);
        System.out.println("Vector1: " + vector1.toString());
        Vector vector2 = new Vector(vector1);
        System.out.println("Vector2: " + vector2.toString());

        System.out.println();
        System.out.println("Equals by hashcode:");
        System.out.println("Vector & Vector1: " + (vector.hashCode() == vector2.hashCode()));
        System.out.println("Vector1 & Vector2: " + (vector1.hashCode() == vector2.hashCode()));

        System.out.println();
        vector2.getSpread();
        System.out.println("Spread Vector2: " + vector2.toString());

        vector2.multiplyByScalar(4);
        System.out.println("Multiply by scalar Vector2: " + vector2);

        System.out.println("Vector, index = 2: " + vector.getComponentByIndex(2));
        vector.setComponentByIndex(0, 10);
        System.out.println("Vector, change element by index = 0: " + vector.toString());

        double[] a = {1, 2, 3, 4};
        double[] b = {1, 1, 1, 1, 5, 5, 5, 5};
        Vector test1 = new Vector(a);
        System.out.println();
        System.out.println("test1 = " + test1.toString());
        Vector test2 = new Vector(b);
        System.out.println("test2 = " + test2.toString());
        System.out.println("Scalar Product By a & b: " + Vector.getScalarProduct(test1, test2));
    }
}
