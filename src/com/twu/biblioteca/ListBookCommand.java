package com.twu.biblioteca;

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
    public String displayName() {
        return "List Books";
    }
}
