package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BibliotecaControllerTest {

    private PrintStream out;
    private BibliotecaController controller;
    private Menu menu;
    private DoneState done;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
        menu = mock(Menu.class);
        done = mock(DoneState.class);
        controller = new BibliotecaController(out, menu, done);
    }

    @Test
    public void shouldPrintWelcomeMessageOnStart() throws IOException {
        when(done.isDone()).thenReturn(true);
        controller.start();
        verify(out).println("Welcome!");
    }

    @Test
    public void shouldRunMenuWhenControllerStarts() throws IOException {
        when(done.isDone()).thenReturn(true);
        controller.start();
        verify(menu).run();
    }

    @Test
    public void shouldQuitWhenOptionSelected() throws IOException {
        when(done.isDone()).thenReturn(false).thenReturn(true);
        controller.start();
        verify(menu, times(2)).run();
    }

}