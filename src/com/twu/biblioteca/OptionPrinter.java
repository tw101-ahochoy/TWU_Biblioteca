package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;

import java.io.PrintStream;
import java.util.List;

public class OptionPrinter {
    private PrintStream printStream;
    private List<Command> commands;

    public OptionPrinter(PrintStream printStream, List<Command> commands) {
        this.printStream = printStream;
        this.commands = commands;
    }


    public void print() {
        int i = 1;
        for (Command command : commands) {
            printStream.println(i + ") " + command.name());
            i++;
        }
    }
}
