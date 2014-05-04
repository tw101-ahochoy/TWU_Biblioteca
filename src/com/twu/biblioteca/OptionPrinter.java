package com.twu.biblioteca;

import java.io.PrintStream;

public class OptionPrinter {
    private PrintStream printStream;

    public OptionPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }


    public void print() {
        printStream.println("1) List books");
        printStream.println("2) Check out book");
        printStream.println("3) Return book");
        printStream.println("4) Quit");
    }
}
