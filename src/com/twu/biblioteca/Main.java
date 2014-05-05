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
        Collection<Book> books = new HashSet<Book>();
        books.add(new Book("The Bible"));
        books.add(new Book("Slaughterhouse Five"));
        Collection<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Dark Knight", "2009", "Christopher Nolan", "9/10"));
        MovieStringConverter movieConverter = new MovieStringConverter();
        Library library = new Library(initialBookTitles(), books, new HashSet<String>(), out, new StringJoiner(), movieList, movieConverter);

        List<Command> commands = commands(reader, out, done, library);
        OptionPrinter optionPrinter = new OptionPrinter(out, commands);
        Menu menu = new Menu(out, reader, optionPrinter, commands);
        BibliotecaController controller = new BibliotecaController(out, menu, done);

        controller.start();
    }

    private static List <Command> commands(BufferedReader reader, PrintStream out, DoneState done, Library library) {
        List<Command> commands = new ArrayList<Command>();
        commands.add(new ListBookCommand(library));
        commands.add(new CheckoutCommand(out, library, reader));
        commands.add(new ReturnCommand(out, reader, library));
        commands.add(new ListMovieCommand(library));
        commands.add(new QuitCommand(done));
        return commands;
    }

    private static List<String> initialBookTitles() {
        List<String> initialBooks = new ArrayList<String>();
        initialBooks.add("The Bible");
        initialBooks.add("Slaughterhouse Five");

        return initialBooks;
    }
}
