package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnBookInformation(){
        Book book = new Book("A Title");
        assertEquals("A Title", book.information());
    }

}