package ru.academits.koloskova.shapes.main;

import ru.academits.koloskova.shapes.Square;
import ru.academits.koloskova.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangle =  new Triangle(1,6,4,9,2,2);
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
    }
}
