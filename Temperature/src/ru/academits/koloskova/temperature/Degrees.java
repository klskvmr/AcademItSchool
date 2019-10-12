package ru.academits.koloskova.temperature;

public class Degrees {
    private double count;
    private Scale scale;

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
