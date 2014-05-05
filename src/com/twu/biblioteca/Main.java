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

    private static Map<String, Command> commands(BufferedReader reader, PrintStream out, DoneState done, Library library) {
        Map<String,Command> commandMap = new HashMap<String, Command>();
        commandMap.put("1", new ListBookCommand(library));
        commandMap.put("2", new CheckoutCommand(out, library, reader));
        commandMap.put("3", new ReturnCommand(out, reader, library));
        commandMap.put("4", new QuitCommand(done));
        return commandMap;
    }

    private static List<String> initialBooks() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");

        return initialBooks;
    }
}
