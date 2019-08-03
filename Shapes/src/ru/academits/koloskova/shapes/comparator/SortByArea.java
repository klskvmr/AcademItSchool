package ru.academits.koloskova.shapes.comparator;

import ru.academits.koloskova.shapes.Shape;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {
    private static final double epsilon = 1.0e-10;

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (shape2.getArea() - shape1.getArea() > epsilon) {
            return -1;
        } else if (Math.abs(shape2.getArea() - shape1.getArea()) <= epsilon) {
            return 0;
        }
        return 1;
    }
}