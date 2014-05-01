package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class OptionPrinterTest {

    private PrintStream printStream = mock(PrintStream.class);
    private OptionPrinter optionPrinter = new OptionPrinter(printStream);

    @Test
    public void shouldPrintOptions() {
        optionPrinter.print();
        verify(printStream).println("1) List books");
        verify(printStream).println("2) Check out book");
        verify(printStream).println("3) Return book");
        verify(printStream).println("4) Quit");
    }

}