package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PrintStream out = System.out;

        Library library = new Library(initialBooks(), new HashSet<String>(), out, new StringJoiner());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionPrinter optionPrinter = new OptionPrinter(out);
        Menu menu = new Menu(out, library, reader, optionPrinter);
        BibliotecaController controller = new BibliotecaController(out, menu);
        controller.start();
    }
    private static List<String> initialBooks() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");

        return initialBooks;
    }

}
