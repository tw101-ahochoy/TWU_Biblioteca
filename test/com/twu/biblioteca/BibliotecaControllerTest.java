package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaControllerTest {

    private PrintStream out;
    private BibliotecaController controller;
    private Library library;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
        library = mock(Library.class);
        controller = new BibliotecaController(out, library);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarts(){
        controller.start();
        verify(out).println("Welcome!");
    }

    @Test
    public void shouldPrintBookListAfterWelcomeWhenStarts(){
        when(library.books()).thenReturn("a");
        controller.start();
        verify(out).println("a");
    }

}