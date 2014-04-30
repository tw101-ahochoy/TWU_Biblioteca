package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldRePromptWhenGivenInvalidOption() throws IOException {
        when(reader.readLine()).thenReturn("argleflarble");
        menu.doSomething();
        verify(reader).readLine();
        verify(printStream).println("Select a valid option!");
        verify(library, never()).listBooks();
    }

    @Test
    public void shouldNotListBooksUnlessGivenOne() throws IOException {
        when(reader.readLine()).thenReturn("2");
        menu.doSomething();
        verify(reader).readLine();
        verify(printStream).println("Select a valid option!");
        verify(library, never()).listBooks();
    }
    @Test
    public void shouldReturn0WhenQuitReceived() throws IOException {
        when(reader.readLine()).thenReturn("Quit");
        int returnValue = menu.doSomething();
        assertThat(returnValue, is(0));
    }
    @Test
    public void shouldNotReturn0UnlessQuitReceived() throws IOException {
        when(reader.readLine()).thenReturn("1");
        int returnValue = menu.doSomething();
        assertThat(returnValue, not(is(0)));
    }
}