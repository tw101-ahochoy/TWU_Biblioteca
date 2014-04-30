package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by manderso on 4/29/14.
 */
public class Menu {
    private PrintStream printStream;
    private Library library;
    private BufferedReader reader;

    public Menu(PrintStream printStream, Library library, BufferedReader reader) {
        this.printStream = printStream;
        this.library = library;
        this.reader = reader;
    }

    public void printOptions() {
        printStream.println("1) List Books");
    }

    public void doSomething() throws IOException {
        String input = reader.readLine();
        if (input.equals("1")) {
            library.listBooks();
        } else {
            printStream.println("Select a valid option!");
        }
    }
}
