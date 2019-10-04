package ru.academits.koloskova.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }


    @Override
    public String toString() {
        return "Figure type: " + getClass().getSimpleName() + System.lineSeparator() +
                "Width: " + getWidth() + System.lineSeparator() +
                "Height: " + getHeight() + System.lineSeparator() +
                "Area: " + getArea() + System.lineSeparator() +
                "Perimeter: " + getPerimeter() + System.lineSeparator();
    }

    @Override
    public boolean equals(Object object) {
        // проверили что передали сам объект
        if (object == this) {
            return true;
        }
        // отсеяли null и объекты других классов
        if (object == null || object.getClass() != getClass()) {
            return false;
        }
        // привели объект к Circle
        Circle circle = (Circle) object;
        // проверили равенство полей
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(radius);

        return hash;
    }
}