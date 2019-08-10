package ru.academits.koloskova.shapes;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
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
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;
        return height == rectangle.height && width == rectangle.width;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(height);
        hash = prime * hash + Double.hashCode(width);

        return hash;
    }
}
