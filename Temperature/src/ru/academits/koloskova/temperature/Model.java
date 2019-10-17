package ru.academits.koloskova.temperature;

import ru.academits.koloskova.temperature.pojo.Degrees;
import ru.academits.koloskova.temperature.pojo.Scale;

class Model {
    private Degrees inputDegrees;
    private Degrees outputDegrees;

    Model() {
        inputDegrees = new Degrees(0, Scale.CELSIUS);
        outputDegrees = new Degrees(0, Scale.CELSIUS);
    }

    Degrees getInputDegrees() {
        return inputDegrees;
    }

    Degrees getOutputDegrees() {
        return outputDegrees;
    }

    void convert() {
        switch (inputDegrees.getScale()) {
            case CELSIUS:
                convertCelsius();
                break;
            case KELVIN:
                convertKelvin();
                break;
            default:
                convertFahrenheit();
        }
    }

    private void convertCelsius() {
        switch (outputDegrees.getScale()) {
            case FAHRENHEIT:
                outputDegrees.setCount(inputDegrees.getCount() * 9 / 5 + 32);
                break;
            case KELVIN:
                outputDegrees.setCount(inputDegrees.getCount() + 273.15);
                break;
            default:
                outputDegrees.setCount(inputDegrees.getCount());
        }
    }

    private void convertFahrenheit() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                outputDegrees.setCount((inputDegrees.getCount() - 32) * 5 / 9);
                break;
            case KELVIN:
                outputDegrees.setCount((inputDegrees.getCount() - 32) * 5 / 9 + 273.15);
                break;
            default:
                outputDegrees.setCount(inputDegrees.getCount());
        }
    }

    private void convertKelvin() {
        switch (outputDegrees.getScale()) {
            case CELSIUS:
                outputDegrees.setCount(inputDegrees.getCount() - 273.15);
                break;
            case FAHRENHEIT:
                outputDegrees.setCount((inputDegrees.getCount() - 273.15) * 9 / 5 + 32);
                break;
            default:
                outputDegrees.setCount(inputDegrees.getCount());
        }
    }
}