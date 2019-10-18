package ru.academits.koloskova.minessweeper.gui;

import ru.academits.koloskova.minessweeper.interfaces.Cell;

public class GUICell implements Cell {
    @Override
    public boolean isBomb() {
        return false;
    }

    @Override
    public boolean isFlag() {
        return false;
    }

    @Override
    public boolean idEmptyFlag() {
        return false;
    }

    @Override
    public void bomb() {

    }

    @Override
    public void empty() {

    }

    @Override
    public void draw(Object paint, boolean real) {

    }
}
