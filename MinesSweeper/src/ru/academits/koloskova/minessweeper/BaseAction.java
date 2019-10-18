package ru.academits.koloskova.minessweeper;

import ru.academits.koloskova.minessweeper.interfaces.*;

public class BaseAction implements UserAction {
    private final BoardGenerator generator;
    private final Board board;
    private final MinesSweeperLogic logic;

    public BaseAction(final MinesSweeperLogic logic, final Board board, final BoardGenerator generator) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    public void select(int x, int y, boolean bomb) {
        this.logic.suggest(x, y, bomb);
        board.drawCell(x, y);
        if (this.logic.bangCheck(x, y)) {
            this.board.drawBang();
        }
        if (this.logic.finish()) {
            board.drawCongratulate();
        }
    }
}