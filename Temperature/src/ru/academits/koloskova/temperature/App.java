package ru.academits.koloskova.temperature;

public class App {
    public static void main(String[] args) {
        View view = new View("My first GUI application");
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.initController();
    }
}
