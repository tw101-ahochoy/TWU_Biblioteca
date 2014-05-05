package com.twu.biblioteca.commands;

import com.twu.biblioteca.DoneState;

public class QuitCommand implements Command {
    private DoneState done;

    public QuitCommand(DoneState done) {
        this.done = done;
    }

    @Override
    public void execute() {
        done.toggle();
    }

    @Override
    public String name() {
        return "Quit";
    }

}
