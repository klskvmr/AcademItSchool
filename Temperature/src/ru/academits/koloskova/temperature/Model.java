package ru.academits.koloskova.temperature;

public class Model {
    private Degrees inputDegrees;
    private Degrees outputDegrees;

    Model() {
    }

    {
        inputDegrees = new Degrees();
        inputDegrees.setCount(0);
        inputDegrees.setScale(Scale.CELSIUS);

        outputDegrees = new Degrees();
        outputDegrees.setCount(0);
        outputDegrees.setScale(Scale.CELSIUS);
    }

    public Degrees getInputDegrees() {
        return inputDegrees;
    }

    public void setInputDegrees(Degrees inputDegrees) {
        this.inputDegrees = inputDegrees;
    }

    Degrees getOutputDegrees() {
        return outputDegrees;
    }

    public void setOutputDegrees(Degrees outputDegrees) {
        this.outputDegrees = outputDegrees;
    }

    void convert() {
        switch (inputDegrees.getScale()) {
            case CELSIUS:
                convertCelsius();
            case FAHRENHEIT:
                convertFahrenheit();
            default:
                convertKelvin();
        }
    }

    private void convertCelsius() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                outputDegrees.setCount(0);
            case FAHRENHEIT:
                outputDegrees.setCount(inputDegrees.getCount());
            default:
                outputDegrees.setCount(inputDegrees.getCount());
        }
    }

    private void convertFahrenheit() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                outputDegrees.setCount(inputDegrees.getCount());
            case FAHRENHEIT:
                outputDegrees.setCount(inputDegrees.getCount());
            default:
                outputDegrees.setCount(inputDegrees.getCount());
        }
    }

    private void convertKelvin() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                outputDegrees.setCount(inputDegrees.getCount());
            case FAHRENHEIT:
                outputDegrees.setCount(inputDegrees.getCount());
            default:
                outputDegrees.setCount(inputDegrees.getCount());
        }
    }
}