package ru.academits.koloskova.shapes;

public interface Shape {
    double epsilon = 1.0e-10;

    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();
}