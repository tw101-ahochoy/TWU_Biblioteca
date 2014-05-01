package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manderso on 4/29/14.
 */
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

    public void run() throws IOException {
        optionPrinter.print();

        String input = reader.readLine();
        if (input.equals("1")){
            library.listBooks();
        } else {
            printStream.println("Select a valid option!");
        }
    }

    public void printOptions() {

        printStream.println("1) List Books");
        printStream.println("2) Check out book");
        printStream.println("3) Return a book");
    }

    public void runOption(String input) throws IOException {

        if (input.equals("Quit")) {
            done = true;
            return;
        }
        if (input.equals("1")) {
            library.listBooks();
        } else if (input.equals("2")) {
            printStream.println("Which book would you like to check out?");
            String book = reader.readLine();
            if (library.checkout(book)) {
                printStream.println("Thank you! Enjoy the book");
            } else {
                printStream.println("That book is not available.");
            }

        } else if (input.equals("3")) {
            printStream.println("What book would you like to return?");
            String book = reader.readLine();
            library.returnBook(book);
        }
        else {
            printStream.println("Select a valid option!");
        }
    }

    public String getInput() throws IOException {
        String input = reader.readLine();
        return input;
    }

    public boolean isDone() {
        return done;
    }
}
