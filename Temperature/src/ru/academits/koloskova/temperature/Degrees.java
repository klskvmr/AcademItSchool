package ru.academits.koloskova.temperature;

public class Degrees {
    private double count;
    private Scale scale;

    public Degrees() {
    }

    public Degrees(Scale scale) {
        this.scale = scale;
    }

    public Degrees(double count, Scale scale) {
        this.count = count;
        this.scale = scale;
    }

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
