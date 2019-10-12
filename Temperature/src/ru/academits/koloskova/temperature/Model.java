package ru.academits.koloskova.temperature;

public class Model {
    private Degrees inputDegrees;
    private Degrees outputDegrees;

    public Model() {
    }

    public Degrees getInputDegrees() {
        return inputDegrees;
    }

    public void setInputDegrees(Degrees inputDegrees) {
        this.inputDegrees = inputDegrees;
    }

    public Degrees getOutputDegrees() {
        return outputDegrees;
    }

    public void setOutputDegrees(Degrees outputDegrees) {
        this.outputDegrees = outputDegrees;
    }

    public double convert() {
        switch (inputDegrees.getScale()) {
            case CELSIUS:
                return convertCelsius();
            case FAHRENHEIT:
                return convertFahrenheit();
            default:
                return convertKelvin();
        }
    }

    private double convertCelsius() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                return inputDegrees.getCount();
            case FAHRENHEIT:
                return 0;
            default:
                return inputDegrees.getCount() + 273.15;
        }
    }

    private double convertFahrenheit() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                return inputDegrees.getCount();
            case FAHRENHEIT:
                return 0;
            default:
                return inputDegrees.getCount() + 273.15;
        }
    }

    private double convertKelvin() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                return inputDegrees.getCount();
            case FAHRENHEIT:
                return 0;
            default:
                return inputDegrees.getCount() + 273.15;
        }
    }
}