package com.twu.biblioteca;

import com.twu.biblioteca.commands.Command;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OptionPrinterTest {

    private PrintStream printStream;
    private OptionPrinter optionPrinter;
    private List<Command> commands;
    private Command command;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        commands = new ArrayList<Command>();
        optionPrinter = new OptionPrinter(printStream, commands);
        command = mock(Command.class);
        when(command.name()).thenReturn("CommandName");
        commands.add(command);
    }

    @Test
    public void shouldPrintOneOptions() {
        optionPrinter.print();
        verify(printStream).println("1) CommandName");
    }

    @Test
    public void shouldPrintThreeOptions(){
        commands.add(command);
        commands.add(command);
        optionPrinter.print();
        verify(printStream).println("3) CommandName");
    }

}