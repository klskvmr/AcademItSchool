package ru.academits.koloskova.temperature;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener, ListSelectionListener {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    private void initView() {
    }

    private void initController(){
        view.getConvert().addActionListener(e -> translateTemperature());
    }

    private void translateTemperature(){
        model.getInputDegrees().setCount(Double.parseDouble(view.getInputDegrees().getText()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }
}
