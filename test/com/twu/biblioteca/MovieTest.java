package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnOwnInformation() {
        Movie movie = new Movie("My Name", "2014", "Mr. Director", "8/10");
        assertEquals("My Name, 2014, Mr. Director, 8/10", movie.getMovieInformation());
    }
}