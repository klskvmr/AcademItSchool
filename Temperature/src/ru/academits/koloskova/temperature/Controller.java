package ru.academits.koloskova.temperature;

import ru.academits.koloskova.temperature.pojo.Scale;

import javax.swing.*;

class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initView();
        initController();
    }

    private void initView() {
        view.getOutputDegrees().setText(model.getOutputDegrees().getCount() + "");
    }

    private void initController() {
        getSelectedScales();

        listenConvertButton();
    }

    private void listenConvertButton() {

        view.getConvertButton().addActionListener(e -> {
            String text = view.getInputDegrees().getText();

            if (hasErrors(text)) {
                return;
            }

            double inputCount = Double.parseDouble(view.getInputDegrees().getText());

            model.getInputDegrees().setCount(inputCount);
            model.convert();

            initView();
        });
    }

    private boolean hasErrors(String text) {
        if (text.equals("")) {
            return true;
        }

        if (text.contains(",")) {
            view.error("Only \".\" allowed");
            return true;
        }

        int dotSignIndex = text.indexOf(".");

        if (text.lastIndexOf(".") != dotSignIndex) {
            view.error("Only one \".\" allowed");
            return true;
        }

        int minusSignIndex = text.indexOf("-");

        if (text.lastIndexOf("-") != minusSignIndex) {
            view.error("Only one \"-\" allowed");
            return true;
        }

        for (int i = 0; i < text.length(); i++) {
            if (i == minusSignIndex || i == dotSignIndex) {
                continue;
            }

            if (!Character.isDigit(text.charAt(i))) {
                view.error("You should use only numbers");
                return true;
            }
        }

        return false;
    }

    private void getSelectedScales() {
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

            for (Scale scale : Scale.values()) {
                if (scale.getTitle().equals(toScale)) {
                    model.getOutputDegrees().setScale(scale);
                }
            }
        });
    }
}