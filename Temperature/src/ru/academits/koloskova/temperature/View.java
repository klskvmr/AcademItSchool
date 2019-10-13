package ru.academits.koloskova.temperature;

import javax.swing.*;
import java.awt.*;

class View {
    private JFrame frame;
    private JPanel panel;

    private JComboBox fromScales;
    private JComboBox toScales;
    private JTextField inputDegrees;
    private JLabel outputDegrees;
    private JButton convertButton;

    View(String title) {
        frame = getFrame(title);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.pink);

        String[] scales = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
        fromScales = new JComboBox(scales);
        toScales = new JComboBox(scales);
        inputDegrees = new JTextField("0");
        outputDegrees = new JLabel();
        convertButton = new JButton("convert");
        JLabel degrees = new JLabel("degrees");

        GridBagConstraints constraints = new GridBagConstraints();
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
        panel.add(outputDegrees, constraints);

        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel.add(degrees, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(convertButton, constraints);

        panel.revalidate();
    }

    JFrame getFrame(String title) {
        JFrame frame = new JFrame(title) {
        };
        int width = 450;
        int height = 200;
        frame.setSize(width, height); // размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // показать фрейм

        return frame;
    }

    public JLabel getOutputDegrees() {
        return outputDegrees;
    }

    public JTextField getInputDegrees() {
        return inputDegrees;
    }

    public JComboBox getFromScales() {
        return fromScales;
    }

    public JComboBox getToScales() {
        return toScales;
    }

    public JButton getConvertButton() {
        return convertButton;
    }
}