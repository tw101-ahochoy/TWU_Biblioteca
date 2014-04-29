package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manderso on 4/29/14.
 */
public class BibliotecaController {


    private PrintStream printStream;
    private Library library;

    public BibliotecaController(PrintStream printStream, Library library) {
        this.printStream = printStream;
        this.library = library;
    }

    public void start() {
        printStream.println("Welcome!");
        printStream.println(library.books());
    }
}
