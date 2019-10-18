package ru.academits.koloskova.minessweeper;

import ru.academits.koloskova.minessweeper.gui.GUIAction;
import ru.academits.koloskova.minessweeper.gui.GUIBoard;
import ru.academits.koloskova.minessweeper.gui.GUICell;
import ru.academits.koloskova.minessweeper.interfaces.Cell;
import ru.academits.koloskova.minessweeper.model.Easy;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    private static final JPanel controlPanel = new JPanel();
    private static final GUIBoard board = new GUIBoard();

    public static void main(String[] arg) {
        SwingUtilities.invokeLater((Runnable) () -> {
            final JFrame frame = new JFrame();
            frame.setTitle("Сапер");
            frame.setLayout(new BorderLayout());
            frame.setSize(500, 500);
/*            frame.add(board, BorderLayout.CENTER);
            board.setBorder(new EmptyBorder(10, 10, 10, 10));*/
            frame.add(controlPanel, BorderLayout.PAGE_END);
            controlPanel.setLayout(new FlowLayout());
            final JButton generate = new JButton("Начать");
            generate.addActionListener(
                    new GUIAction(
                            new Easy(), board,
                            () -> new Cell[][]{{new GUICell(), new GUICell()}, {new GUICell(), new GUICell()}}
                    ));
            controlPanel.add(generate);
            centre(frame);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    closePerform(frame);
                }
            });
            frame.setVisible(true);
        });
    }


    static void centre(Window w) {
        Dimension us = w.getSize();
        Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (them.width - us.width) / 2;
        int newY = (them.height - us.height) / 2;
        w.setLocation(newX, newY);

    }

    static void closePerform(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}