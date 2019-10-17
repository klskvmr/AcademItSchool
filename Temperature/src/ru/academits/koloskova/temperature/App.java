package ru.academits.koloskova.temperature;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // установка Look and Feel для текущей ОС
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            View view = new View("My temperature transfer GUI application");
            Model model = new Model();
            Controller controller = new Controller(model, view);
        });
    }
}
