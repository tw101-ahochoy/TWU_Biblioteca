package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Collection;

public class Library {

    private Collection<String> books;
    private PrintStream printStream;
    private StringJoiner joiner;

    public Library(Collection<String> initialBooks, PrintStream printStream, StringJoiner joiner) {
        this.books = initialBooks;
        this.printStream = printStream;
        this.joiner = joiner;
    }

    public void listBooks() {
        String joinedBooks = joiner.join(books);
        printStream.println(joinedBooks);
    }

    public boolean checkout(String book) {
        if (books.contains(book)) {
            books.remove(book);
            printStream.println("Thank you! Enjoy the book.");
            return true;
        } else {
            return false;
        }
    }

    public void returnBook(String book) {
        books.add(book);
    }
}
