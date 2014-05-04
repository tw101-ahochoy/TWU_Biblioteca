package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
public class Menu {
    private PrintStream printStream;
    private Library library;
    private BufferedReader reader;
    private boolean done = false;
    private OptionPrinter optionPrinter;

    public Menu(PrintStream printStream, Library library, BufferedReader reader, OptionPrinter optionPrinter) {
        this.printStream = printStream;
        this.library = library;
        this.reader = reader;
        this.optionPrinter = optionPrinter;
    }

    public void run() {
        optionPrinter.print();

        String input = readLine();
        if (input.equals("4")){
            done = true;
        } else if (input.equals("3")) {
            printStream.println("Which book would you like to return?");
            library.returnBook(readLine());
        } else if (input.equals("2")){
            printStream.println("Which book would you like to check out?");
            library.checkout(readLine());
        } else if (input.equals("1")){
            library.listBooks();
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

    public boolean isDone() {
        return done;
    }
}
