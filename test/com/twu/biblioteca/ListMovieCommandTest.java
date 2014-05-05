package com.twu.biblioteca;

import com.twu.biblioteca.commands.ListMovieCommand;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMovieCommandTest {

    @Test
    public void shouldListMovies() {
        Library library = mock(Library.class);
        ListMovieCommand listMovie = new ListMovieCommand(library);
        listMovie.execute();
        verify(library).listMovies();
    }
}