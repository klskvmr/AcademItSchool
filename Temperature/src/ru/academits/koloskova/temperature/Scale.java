package ru.academits.koloskova.temperature;

public enum Scale {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private String string;

    Scale(String string) {
        this.string = string;
    }
}
