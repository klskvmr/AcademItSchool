package ru.academits.koloskova.minessweeper.interfaces;

public interface UserAction {
    void initGame();

    void select(int x, int y, boolean isBomb);
}
