package com.twu.biblioteca.commands;

import com.twu.biblioteca.Library;

public class ListMovieCommand implements Command {
    private Library library;

    public ListMovieCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.listMovies();

    }

    @Override
    public String name() {
        return "List Movies";
    }
}
