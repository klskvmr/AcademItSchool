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
    private JLabel degrees;
    private JButton convertButton;

    View(String title) {
        SwingUtilities.invokeLater(() -> {
            // установка Look and Feel для текущей ОС
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            frame = getFrame(title);
            panel = new JPanel();
            frame.add(panel);
            panel.setLayout(new GridBagLayout());

            String[] scales = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
            fromScales = new JComboBox(scales);
            toScales = new JComboBox(scales);
            inputDegrees = new JTextField("0");
            outputDegrees = new JLabel();
            degrees = new JLabel("degrees");
            convertButton = new JButton("convert");

            GridBagConstraints constraints1 = new GridBagConstraints();
            constraints1.weightx = 0;
            constraints1.weighty = 0;
            constraints1.gridx = 0;
            constraints1.gridy = 0;
            constraints1.gridwidth = 4;
            constraints1.gridheight = 1;
            panel.add(new JLabel("Temperature conversation"), constraints1);

            GridBagConstraints constraints2 = new GridBagConstraints();
            constraints2.weightx = 0;
            constraints2.weighty = 0;
            constraints2.gridx = 0;
            constraints2.gridy = 1;
            constraints2.gridwidth = 1;
            constraints2.gridheight = 1;
            panel.add(new JLabel("From"), constraints2);

            GridBagConstraints constraints3 = new GridBagConstraints();
            constraints3.weightx = 0;
            constraints3.weighty = 0;
            constraints3.gridx = 1;
            constraints3.gridy = 1;
            constraints3.gridwidth = 1;
            constraints3.gridheight = 1;
            panel.add(fromScales, constraints3);

            GridBagConstraints constraints4 = new GridBagConstraints();
            constraints4.weightx = 0;
            constraints4.weighty = 0;
            constraints4.gridx = 2;
            constraints4.gridy = 1;
            constraints4.gridwidth = 1;
            constraints4.gridheight = 1;
            panel.add(new JLabel("To"), constraints4);

            GridBagConstraints constraints5 = new GridBagConstraints();
            constraints5.weightx = 0;
            constraints5.weighty = 0;
            constraints5.gridx = 3;
            constraints5.gridy = 1;
            constraints5.gridwidth = 1;
            constraints5.gridheight = 1;
            panel.add(toScales, constraints5);

            GridBagConstraints constraints6 = new GridBagConstraints();
            constraints6.weightx = 0;
            constraints6.weighty = 0;
            constraints6.gridx = 0;
            constraints6.gridy = 2;
            constraints6.gridwidth = 2;
            constraints6.gridheight = 1;
            constraints6.anchor = GridBagConstraints.LINE_START;
            panel.add(new JLabel("Enter temperature"), constraints6);

            GridBagConstraints constraints7 = new GridBagConstraints();
            constraints7.weightx = 0;
            constraints7.weighty = 0;
            constraints7.gridx = 2;
            constraints7.gridy = 2;
            constraints7.gridwidth = 2;
            constraints7.gridheight = 1;
            constraints7.anchor = GridBagConstraints.LINE_START;
            panel.add(new JLabel("Temperature on new scale"), constraints7);

            GridBagConstraints constraints8 = new GridBagConstraints();
            constraints8.weightx = 0;
            constraints8.weighty = 0;
            constraints8.gridx = 0;
            constraints8.gridy = 3;
            constraints8.gridwidth = 1;
            constraints8.gridheight = 1;
            panel.add(inputDegrees, constraints8);

            GridBagConstraints constraints9 = new GridBagConstraints();
            constraints9.weightx = 0;
            constraints9.weighty = 0;
            constraints9.gridx = 1;
            constraints9.gridy = 3;
            constraints9.gridwidth = 1;
            constraints9.gridheight = 1;
            panel.add(new JLabel("degrees"), constraints9);

            GridBagConstraints constraints10 = new GridBagConstraints();
            constraints10.weightx = 0;
            constraints10.weighty = 0;
            constraints10.gridx = 2;
            constraints10.gridy = 3;
            constraints10.gridwidth = 1;
            constraints10.gridheight = 1;
            constraints10.anchor = GridBagConstraints.LINE_START;
            panel.add(outputDegrees, constraints10);

            GridBagConstraints constraints11 = new GridBagConstraints();
            constraints11.weightx = 0;
            constraints11.weighty = 0;
            constraints11.gridx = 3;
            constraints11.gridy = 3;
            constraints11.gridwidth = 1;
            constraints11.gridheight = 1;
            panel.add(degrees, constraints11);

            GridBagConstraints constraints12 = new GridBagConstraints();
            constraints12.weightx = 0;
            constraints12.weighty = 0;
            constraints12.gridx = 0;
            constraints12.gridy = 4;
            constraints12.gridwidth = 4;
            constraints12.gridheight = 1;
            panel.add(convertButton, constraints12);

            panel.revalidate();
        });
    }

    JFrame getFrame(String title) {
        JFrame frame = new JFrame(title) {
        };

        int width = 400;
        int height = 200;
        frame.setSize(width, height); // размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // показать фрейм

        return frame;
    }

    public JLabel getOutputDegrees() {
        return outputDegrees;
    }

    public void setOutputDegrees(JLabel outputDegrees) {
        this.outputDegrees = outputDegrees;
    }

    public JTextField getInputDegrees() {
        return inputDegrees;
    }

    public void setInputDegrees(JTextField inputDegrees) {
        this.inputDegrees = inputDegrees;
    }

    public JComboBox getFromScales() {
        return fromScales;
    }

    public void setFromScales(JComboBox fromScales) {
        this.fromScales = fromScales;
    }

    public JComboBox getToScales() {
        return toScales;
    }

    public void setToScales(JComboBox toScales) {
        this.toScales = toScales;
    }

    public JButton getConvertButton() {
        return convertButton;
    }

    public void setConvertButton(JButton convertButton) {
        this.convertButton = convertButton;
    }
}
