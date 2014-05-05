package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Menu {
    private PrintStream printStream;
    private BufferedReader reader;
    private OptionPrinter optionPrinter;
    private List<Command> commands;

    public Menu(PrintStream printStream, BufferedReader reader, OptionPrinter optionPrinter, List<Command> commands) {
        this.printStream = printStream;
        this.reader = reader;
        this.optionPrinter = optionPrinter;
        this.commands = commands;
    }

    public void run() {
        optionPrinter.print();

        String input = readLine();
        int inputValue;
        if(StringUtils.isNumeric(input)) {
            inputValue = Integer.parseInt(input) - 1;
            if(commands.get(inputValue) != null) {
                commands.get(inputValue).execute();
                return;
            }
        }
        printStream.println("Select a valid option!");
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
