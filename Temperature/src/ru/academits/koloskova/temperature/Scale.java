package ru.academits.koloskova.temperature;

public enum Scale {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private String title;

    Scale(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
