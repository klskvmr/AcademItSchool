package ru.academits.koloskova.temperature;

import javax.swing.*;
import java.awt.*;

class View {
    private JComboBox fromScales;
    private JComboBox toScales;
    private JTextArea inputDegrees;
    private JLabel outputDegrees;
    private JButton convertButton;

    private JPanel panel;
    private GridBagConstraints constraints;

    View(String title) {
        JFrame frame = getFrame(title);
panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.pink);

        String[] scales = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
        fromScales = new JComboBox(scales);
        toScales = new JComboBox(scales);
        inputDegrees = new JTextArea("0");
        outputDegrees = new JLabel();
        convertButton = new JButton("convert");

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        panel.add(new JLabel("Temperature conversation"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(new JLabel("From"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(fromScales, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(new JLabel("To"), constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(toScales, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        panel.add(new JLabel("Enter temperature"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        panel.add(new JLabel("Temperature on new scale"), constraints);

        constraints.fill = GridBagConstraints.NONE;

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        Font font = new Font(Font.SERIF, Font.PLAIN, 25);
        inputDegrees.setFont(font);
        panel.add(inputDegrees, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(new JLabel("degrees"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        outputDegrees.setFont(font);
        panel.add(outputDegrees, constraints);

        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(new JLabel("degrees"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(convertButton, constraints);

        panel.revalidate();
    }

    private JFrame getFrame(String title) {
        JFrame frame = new JFrame(title) {
        };
        int width = 500;
        int height = 300;
        frame.setSize(width, height); // размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // показать фрейм

        return frame;
    }

    JLabel getOutputDegrees() {
        return outputDegrees;
    }

    JTextArea getInputDegrees() {
        return inputDegrees;
    }

    JComboBox getFromScales() {
        return fromScales;
    }

    JComboBox getToScales() {
        return toScales;
    }

    JButton getConvertButton() {
        return convertButton;
    }

    void error(String error){
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(new Label(error), constraints);
    }
}