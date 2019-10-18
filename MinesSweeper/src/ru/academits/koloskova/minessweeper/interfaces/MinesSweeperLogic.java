package ru.academits.koloskova.minessweeper.interfaces;

public interface MinesSweeperLogic {
    void loadBoard(Cell[][] cells);

    boolean bangCheck(int x, int y);

    boolean finish();

    void suggest(int x, int y, boolean bomb);
}