package ru.academits.koloskova.shapes.comparator;

import ru.academits.koloskova.shapes.Shape;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {
    private static final double epsilon = 1.0e-10;

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (shape2.getPerimeter() - shape1.getPerimeter() > epsilon) {
            return -1;
        } else if (Math.abs(shape2.getPerimeter() - shape1.getPerimeter()) <= epsilon) {
            return 0;
        }
        return 1;
    }
}
