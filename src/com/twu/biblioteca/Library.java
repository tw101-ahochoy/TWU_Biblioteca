package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Library {

    private Collection<String> bookTitles;
    private Collection<Book> books;
    private Collection<String> checkedOutBooks;
    private PrintStream printStream;
    private StringJoiner joiner;
    private Collection<Movie> movieList;
    private MovieStringConverter movieConverter;

    public Library(Collection<String> bookTitles, Collection<Book> books, Collection<String> checkedOutBooks, PrintStream printStream, StringJoiner joiner, Collection<Movie> movieList, MovieStringConverter movieConverter) {
        this.bookTitles = bookTitles;
        this.books = books;
        this.checkedOutBooks = checkedOutBooks;
        this.printStream = printStream;
        this.joiner = joiner;
        this.movieList = movieList;
        this.movieConverter = movieConverter;
    }

    public void listBooks() {
        List<String> bookInformationList = new ArrayList<String>();
        for (Book book : books) {
            bookInformationList.add(book.information());
        }

        printStream.println(joiner.join(bookInformationList));
    }

    public boolean checkout(String book) {
        if (bookTitles.contains(book)) {
            bookTitles.remove(book);
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
            bookTitles.add(book);
            printStream.println("Thank you for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    public boolean isCheckedOut(String book) {
        return checkedOutBooks.contains(book);
    }

    public void listMovies() {
        List<String> movieStringList = movieConverter.invoke(movieList);
        joiner.join(movieStringList);
    }

}
