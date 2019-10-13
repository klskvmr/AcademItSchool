package ru.academits.koloskova.temperature;

import ru.academits.koloskova.temperature.pojo.Scale;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initView();
    }

    void initView() {
    }

    void initController() {
        view.getFromScales().addActionListener(e -> {
            JComboBox box = (JComboBox) e.getSource();
            String fromScale = (String) box.getSelectedItem();
            for (Scale scale : Scale.values()) {
                if (scale.getTitle().equals(fromScale)) {
                    model.getInputDegrees().setScale(scale);
                }
            }
        });

        view.getToScales().addActionListener(e -> {
            JComboBox box = (JComboBox) e.getSource();
            String toScale = (String) box.getSelectedItem();

//            String toScale = (String) view.getFromScales().getSelectedItem();

            for (Scale scale : Scale.values()) {
                if (scale.getTitle().equals(toScale)) {
                    model.getOutputDegrees().setScale(scale);
                }
            }
        });

        view.getConvertButton().addActionListener(e -> {
            double inputCount = Double.parseDouble(view.getInputDegrees().getText());
            model.getInputDegrees().setCount(inputCount);
            model.convert();
            view.getOutputDegrees().setText(model.getOutputDegrees().getCount() + "");
        });
    }
}