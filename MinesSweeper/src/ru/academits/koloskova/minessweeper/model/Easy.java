package ru.academits.koloskova.minessweeper.model;

import ru.academits.koloskova.minessweeper.interfaces.Cell;
import ru.academits.koloskova.minessweeper.interfaces.MinesSweeperLogic;

public class Easy implements MinesSweeperLogic {
    private Cell[][] cells;

    @Override
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public boolean bangCheck(int x, int y) {
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isFlag();
    }

    @Override
    public boolean finish() {
        boolean finish = false;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                finish = ((cell.isFlag() && cell.isBomb()) ||
                        (cell.isFlag() && !cell.isBomb()));
            }
        }
        return finish;
    }

    @Override
    public void suggest(int x, int y, boolean bomb) {
        if (bomb) {
            this.cells[x][y].bomb();
        } else {
            this.cells[x][y].empty();
        }
    }
}