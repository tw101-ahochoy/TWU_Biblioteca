package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;
    private Library library;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        menu = new Menu(printStream, library, reader);
    }

    @Test
    public void shouldPrintAnOption(){
        menu.printOptions();
        verify(printStream).println("1) List Books");
    }

    @Test
    public void shouldListBooksWhenGivenOne() throws IOException {
        when(reader.readLine()).thenReturn("1");
        menu.doSomething();
        verify(reader).readLine();
        verify(library).listBooks();
    }

}