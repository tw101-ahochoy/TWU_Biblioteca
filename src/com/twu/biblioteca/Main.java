package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;
        DoneState done = new DoneState(false);
        OptionPrinter optionPrinter = new OptionPrinter(out);
        Library library = new Library(initialBooks(), new HashSet<String>(), out, new StringJoiner());

        Menu menu = new Menu(out, reader, optionPrinter, commands(reader, out, done, library));
        BibliotecaController controller = new BibliotecaController(out, menu, done);

        controller.start();
    }

    private static List <Command> commands(BufferedReader reader, PrintStream out, DoneState done, Library library) {
        List<Command> commands = new ArrayList<Command>();
        commands.add( new ListBookCommand(library));
        commands.add( new CheckoutCommand(out, library, reader));
        commands.add( new ReturnCommand(out, reader, library));
        commands.add( new QuitCommand(done));
        return commands;
    }

    private static List<String> initialBooks() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");

        return initialBooks;
    }
}
