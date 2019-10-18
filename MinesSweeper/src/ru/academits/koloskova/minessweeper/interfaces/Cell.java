package ru.academits.koloskova.minessweeper.interfaces;

public interface Cell<T> {
    boolean isBomb();

    boolean isFlag();

    boolean idEmptyFlag();

    void bomb();

    void empty();

    void draw(T paint, boolean real);
}
