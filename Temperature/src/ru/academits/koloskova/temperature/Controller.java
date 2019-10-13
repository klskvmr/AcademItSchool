package ru.academits.koloskova.temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
        //implements
       // ActionListener, ListSelectionListener
{
    private Model model;
    private View view;

    private ActionListener aL = new Listener();
//    private ActionListener aL = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            view.getOutputDegrees().setText("Hello");
//        }
//    };

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        initView();
    }

    void initView() {
        view.getConvertButton().addActionListener(aL);

//        view.getOutputDegrees().setText(model.getOutputDegrees().getCount() + " ");
    }

    //добавляем экшн лисенеры
    void initController() {
//        view.getConvert().addActionListener(e -> model.convert());
//        view.getConvert().addActionListener(e -> view.getOutputDegrees().setText("Hello"));

        view.getConvertButton().addActionListener(e -> {view.getOutputDegrees().setText("Hello");});
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getOutputDegrees().setText("Hello!");
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        view.getOutputDegrees().setText("Hello");
//    }
}
