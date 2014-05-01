package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;
    private Library library;
    private BufferedReader reader;
    private OptionPrinter optionPrinter;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        optionPrinter = mock(OptionPrinter.class);
        menu = new Menu(printStream, library, reader, optionPrinter);
    }

    @Test
    public void shouldPrintOptionsWhenRun() throws IOException {
        when(reader.readLine()).thenReturn("1");
        menu.run();
        verify(optionPrinter).print();
    }
    
    @Test
    public void shouldDisplayBooksWhenGivenOptionOne() throws IOException {
        when(reader.readLine()).thenReturn("1");
        menu.run();
        verify(library).listBooks();     
    }
    
    @Test
    public void shouldDisplayErrorMessageWhenGivenInvalidInput() throws IOException {
        when(reader.readLine()).thenReturn("Invalid Input");
        menu.run();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldBeDoneWhenUserQuits() throws IOException {
        when(reader.readLine()).thenReturn("4");
        menu.run();
        assertTrue(menu.isDone());
    }

}