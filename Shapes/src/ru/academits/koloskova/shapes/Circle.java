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
        return "Figure type: " + this.getClass().getSimpleName() + System.lineSeparator() +
                "Width: " + this.getWidth() + System.lineSeparator() +
                "Height: " + this.getHeight() + System.lineSeparator() +
                "Area: " + this.getArea() + System.lineSeparator() +
                "Perimeter: " + this.getPerimeter() + System.lineSeparator();
    }

    @Override
    public boolean equals(Object object) {
        // проверили что передали сам объект
        if (object == this) {
            return true;
        }
        // отсеяли null и объекты других классов
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        // привели объект к Circle
        Circle circle = (Circle) object;
        // проверили равенство ссылок и полей
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