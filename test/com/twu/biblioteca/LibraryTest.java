package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private Collection<String> bookTitles;
    private Collection<Book> books;
    private Library library;
    private PrintStream printStream;
    private StringJoiner joiner;
    private Collection<String> checkedOutBooks;
    private Book book;
    public static final String BOOK_INFO = "Book Info";
    private Collection<Movie> movieList;
    private MovieStringConverter movieConverter;

    @Before
    public void setUp() throws Exception {
        bookTitles = new HashSet<String>();
        books = new HashSet<Book>();
        movieConverter = mock(MovieStringConverter.class);
        checkedOutBooks = new HashSet<String>();
        printStream = mock(PrintStream.class);
        joiner = mock(StringJoiner.class);
        movieList = new ArrayList<Movie>();
        library = new Library(bookTitles, books, checkedOutBooks, printStream, joiner, movieList, movieConverter);
        book = mock(Book.class);

    }


    @Test
    public void shouldJoinBookList() {
        when(book.information()).thenReturn(BOOK_INFO);
        books.add(book);
        library.listBooks();
        Collection<String> expectedStrings = new ArrayList<String>();
        expectedStrings.add(BOOK_INFO);
        verify(joiner).join(expectedStrings);
    }

    @Test
    public void shouldPrintJoinedBooks() {
        String joinedBooks = "aaa";
        when(joiner.join(anyCollection())).thenReturn(joinedBooks);
        library.listBooks();
        verify(printStream).println(joinedBooks);
    }

    @Test
    public void shouldNotPrintCheckedOutBook() {
        String book1 = "aaa";
        bookTitles.add(book1);
        library.checkout(book1);
        assertThat(bookTitles, not(hasItem(book1)));
    }

    @Test
    public void shouldReturnBook(){
        checkedOutBooks.add("Book 3");
        library.returnBook("Book 3");
        assertTrue(bookTitles.contains("Book 3"));
    }

    @Test
    public void shouldPrintSuccessfulCheckoutMessage() {
        bookTitles.add("A Good Book");
        library.checkout("A Good Book");
        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldPrintUnsuccessfulCheckoutMessage() {
        library.checkout("I'm not in the library");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldPrintSuccessfulReturnMessage() {
        checkedOutBooks.add("Boo!");
        library.returnBook("Boo!");
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldReturnTrueIfBookIsCheckedOut(){
        bookTitles.add("boo2");
        library.checkout("boo2");
        assertTrue(library.isCheckedOut("boo2"));
    }

    @Test
    public void shouldRemoveBookFromCheckoutListWhenReturned() {
        checkedOutBooks.add("A Book About Books");
        library.returnBook("A Book About Books");
        assertFalse(library.isCheckedOut("A Book About Books"));
    }

    @Test
    public void shouldPrintUnsuccessfulReturnMessage() {
        library.returnBook("No Way!");
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldConvertMovieListToStringList() {
        library.listMovies();
        verify(movieConverter).invoke(movieList);
    }

    @Test
    public void shouldJoinMovieStringList(){
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Bill's not a jerk!");
        when(movieConverter.invoke(movieList)).thenReturn(expectedList);
        library.listMovies();
        verify(joiner).join(expectedList);
    }




}

