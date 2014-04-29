package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {

    private List<String> initialBooks;
    private Library library;

    @Before
    public void setUp() throws Exception {
        initialBooks = new ArrayList<String>();
        library = new Library(initialBooks);
    }

    @Test
    public void shouldListNothingWhenThereAreNoBooks(){
        assertThat(library.books(), is(""));
    }

    @Test
    public void shouldListABook() {
        String bookTitle = "To Kill A MockingBird";
        initialBooks.add(bookTitle);
        assertThat(library.books(), is(bookTitle));
    }
}