package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaController {
    private PrintStream printStream;
    private Menu menu;
    private DoneState done;

    public BibliotecaController(PrintStream printStream, Menu menu, DoneState done) {
        this.printStream = printStream;
        this.menu = menu;
        this.done = done;
    }

    public void start() {
        printStream.println("Welcome!");
        do {
            menu.run();
        } while(!done.isDone());
    }
}
