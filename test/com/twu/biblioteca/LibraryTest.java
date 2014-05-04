package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private Collection<String> books;
    private Library library;
    private PrintStream printStream;
    private StringJoiner joiner;

    @Before
    public void setUp() throws Exception {
        books = new HashSet<String>();
        printStream = mock(PrintStream.class);
        joiner = mock(StringJoiner.class);
        library = new Library(books, printStream, joiner);
    }


    @Test
    public void shouldJoinBookList() {
        library.listBooks();
        verify(joiner).join(books);
    }

    @Test
    public void shouldPrintJoinedBooks() {
        String joinedBooks = "aaa";
        when(joiner.join(books)).thenReturn(joinedBooks);
        library.listBooks();
        verify(printStream).println(joinedBooks);
    }

    @Test
    public void shouldNotPrintCheckedOutBook() {
        String book1 = "aaa";
        books.add(book1);
        library.checkout(book1);
        assertThat(books, not(hasItem(book1)));
    }

    @Test
    public void shouldReturnBook(){
        library.returnBook("Book 3");
        assertTrue(books.contains("Book 3"));
    }

    @Test
    public void shouldPrintSuccessfulCheckoutMessage() {
        books.add("A Good Book");
        library = new Library(books, printStream, joiner);
        library.checkout("A Good Book");
        verify(printStream).println("Thank you! Enjoy the book.");
    }
}