package ru.academits.koloskova.vector.shapes;

public class Triangle implements Shape {
    private static final double epsilon = 1.0e-10;

    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        if (Math.abs(((x3 - x1) * (y2 - y1)) - ((y3 - y1) * (x2 - x1))) <= epsilon) {
            throw new IllegalArgumentException("Точки лежат на одной прямой!");
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    private double getA() {
        return getSide(x1, y1, x2, y2);
    }

    private double getB() {
        return getSide(x1, y1, x3, y3);
    }

    private double getC() {
        return getSide(x2, y2, x3, y3);
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    private static double getSide(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - getA()) * (semiPerimeter - getB()) * (semiPerimeter - getC()));
    }

    @Override
    public double getPerimeter() {
        return getA() + getB() + getC();
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
        Triangle triangle = (Triangle) object;
        return x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 &&
                y2 == triangle.y2 && x3 == triangle.x3 && y3 == triangle.y3;

    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(getA());
        hash = prime * hash + Double.hashCode(getB());
        hash = prime * hash + Double.hashCode(getC());

        return hash;
    }
}