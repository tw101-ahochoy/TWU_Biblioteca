package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private List<String> initialBooks;
    private Library library;
    private PrintStream printStream;
    private StringJoiner joiner;

    @Before
    public void setUp() throws Exception {
        initialBooks = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        joiner = mock(StringJoiner.class);
        library = new Library(initialBooks, printStream, joiner);
    }


    @Test
    public void shouldJoinBookList() {
        library.listBooks();
        verify(joiner).join(initialBooks);
    }

    @Test
    public void shouldPrintJoinedBooks() {
        String joinedBooks = "aaa";
        when(joiner.join(any(List.class))).thenReturn(joinedBooks);
        library.listBooks();
        verify(printStream).println(joinedBooks);
    }
}