package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaControllerTest {

    @Test
    public void shouldSomethingWhenCondition(){
        PrintStream out = mock(PrintStream.class);
        BibliotecaController controller = new BibliotecaController(out);
        controller.start();

        verify(out).println("Welcome!");
    }

}