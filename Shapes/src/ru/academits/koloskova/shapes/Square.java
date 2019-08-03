package ru.academits.koloskova.shapes;

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
        return "Figure type: " + this.getClass().getSimpleName() + System.lineSeparator() +
                "Width: " + this.getWidth() + System.lineSeparator() +
                "Height: " + this.getHeight() + System.lineSeparator() +
                "Area: " + this.getArea() + System.lineSeparator() +
                "Perimeter: " + this.getPerimeter() + System.lineSeparator();
    }

    @Override
    public boolean equals(Object object) {
        // проверили что передали сам объект
        if (object == this) return true;
        // отсеяли null и объекты других классов
        if (object == null || object.getClass() != this.getClass()) return false;
        // привели объект к Square
        Square square = (Square) object;
        // проверили равенство ссылок и полей
        return Math.abs(length - square.length) <= epsilon;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(length);

        return hash;
    }
}