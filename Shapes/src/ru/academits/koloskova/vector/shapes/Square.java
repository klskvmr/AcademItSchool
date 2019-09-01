package ru.academits.koloskova.vector.shapes;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
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
        // привели объект к Square
        Square square = (Square) object;
        // проверили равенство полей
        return length == square.length;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(length);

        return hash;
    }
}