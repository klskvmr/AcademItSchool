package ru.academits.koloskova.vector.main;

import ru.academits.koloskova.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = {1,2,3,4,5};
        Vector vector = new Vector(array);

//        Vector vector = new Vector(4);
        Vector vector1 = new Vector(vector);

        System.out.println(Arrays.toString(vector.getValluesArray()));
        System.out.println(Arrays.toString(vector1.getValluesArray()));
    }
}
