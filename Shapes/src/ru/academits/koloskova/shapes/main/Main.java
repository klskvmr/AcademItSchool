package ru.academits.koloskova.shapes.main;

import ru.academits.koloskova.shapes.*;
import ru.academits.koloskova.shapes.comparator.SortByArea;
import ru.academits.koloskova.shapes.comparator.SortByPerimeter;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Square(2));
        shapes.add(new Triangle(1, 1, 2, 2, 3, 9));
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(10, 5));
        shapes.add(new Square(10));

        shapes.sort(new SortByArea());
        System.out.println("FIGURE WITH MAX AREA");
        System.out.println(shapes.get(shapes.size() - 1).toString());

        shapes.sort(new SortByPerimeter());
        System.out.println("FIGURE WITH THE SECOND LARGEST PERIMETER");
        System.out.println(shapes.get(shapes.size() - 2).toString());
    }
}
