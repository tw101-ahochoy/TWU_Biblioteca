package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

public class MenuTest {

    private PrintStream out;
    private Menu menu;
    private BufferedReader reader;
    private OptionPrinter optionPrinter;
    private Command someCommand;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        optionPrinter = mock(OptionPrinter.class);

        List<Command> commandMap = new ArrayList<Command>();
        someCommand = mock(Command.class);
        commandMap.add(someCommand);

        menu = new Menu(out, reader, optionPrinter, commandMap);
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
        verify(someCommand).execute();
    }
    
    @Test
    public void shouldDisplayErrorMessageWhenGivenInvalidInput() throws IOException {
        when(reader.readLine()).thenReturn("Invalid Input");
        menu.run();
        verify(out).println("Select a valid option!");
    }
}