package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manderso on 4/29/14.
 */
public class BibliotecaController {


    private PrintStream printStream;

    public BibliotecaController(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome!");
        Library library = new Library(initialBooks());
        System.out.println(library.books());
    }

    private static List<String> initialBooks() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");
        return initialBooks;
    }
}
