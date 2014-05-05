package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private PrintStream printStream;
    private BufferedReader reader;
    private OptionPrinter optionPrinter;
    private Map<String, Command> commandMap;

    public Menu(PrintStream printStream, BufferedReader reader, OptionPrinter optionPrinter, Map<String, Command> commandMap) {
        this.printStream = printStream;
        this.reader = reader;
        this.optionPrinter = optionPrinter;
        this.commandMap = commandMap;
    }

    public void run() {
        optionPrinter.print();

        String input = readLine();

        if(commandMap.containsKey(input)) {
            commandMap.get(input).execute();
        } else {
            printStream.println("Select a valid option!");
        }
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
