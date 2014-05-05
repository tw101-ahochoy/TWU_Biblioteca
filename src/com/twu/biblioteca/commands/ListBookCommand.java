package com.twu.biblioteca.commands;

import com.twu.biblioteca.Library;

public class ListBookCommand implements Command {

    private Library library;

    public ListBookCommand(Library library){
        this.library = library;
    }

    @Override
    public void execute() {
        library.listBooks();
    }

    @Override
    public String name() {
        return "List Books";
    }

}
