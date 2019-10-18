package ru.academits.koloskova.minessweeper.gui;

import ru.academits.koloskova.minessweeper.BaseAction;
import ru.academits.koloskova.minessweeper.interfaces.BoardGenerator;
import ru.academits.koloskova.minessweeper.interfaces.MinesSweeperLogic;
import ru.academits.koloskova.minessweeper.interfaces.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIAction extends BaseAction implements ActionListener, MouseListener {
    private GUIBoard board;

    public GUIAction(MinesSweeperLogic logic, GUIBoard board, BoardGenerator generator) {
        super(logic, board, generator);
        this.board = board;
//        this.board.addMouseListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    public void mouseClicked(MouseEvent e) {
//        board.repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}