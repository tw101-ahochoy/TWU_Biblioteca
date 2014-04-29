package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manderso on 4/29/14.
 */
public class Library {

    private List<String> books;
    private PrintStream printStream;
    private StringJoiner joiner;

    public Library(List<String> initialBooks, PrintStream printStream, StringJoiner joiner) {
        this.books = initialBooks;
        this.printStream = printStream;
        this.joiner = joiner;
    }

    public void listBooks() {
        String joinedBooks = joiner.join(books);
        printStream.println(joinedBooks);
    }
}
