package ru.academits.koloskova.shapes.comparator;

import ru.academits.koloskova.shapes.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (Double.compare(shape1.getPerimeter(), shape2.getPerimeter()) < 0) {
            return -1;
        } else if (Double.compare(shape1.getPerimeter(),shape2.getPerimeter()) == 0) {
            return 0;
        }
        return 1;
    }
}
