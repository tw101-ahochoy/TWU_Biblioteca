package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaController {


    private PrintStream printStream;
    private Menu menu;

    public BibliotecaController(PrintStream printStream, Menu menu) {
        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome!");
        do {
            menu.run();
        } while(!menu.isDone());
    }
}
