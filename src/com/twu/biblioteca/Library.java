package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Collection;

public class Library {

    private Collection<String> books, checkedOutBooks;
    private PrintStream printStream;
    private StringJoiner joiner;

    public Library(Collection<String> initialBooks, Collection<String> checkedOutBooks, PrintStream printStream, StringJoiner joiner) {
        this.books = initialBooks;
        this.checkedOutBooks = checkedOutBooks;
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
            checkedOutBooks.add(book);
            printStream.println("Thank you! Enjoy the book.");
            return true;
        } else {
            printStream.println("That book is not available.");
            return false;
        }
    }

    public void returnBook(String book) {
        if (isCheckedOut(book)){
            checkedOutBooks.remove(book);
            books.add(book);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    public boolean isCheckedOut(String book) {
        return checkedOutBooks.contains(book);
    }
}
