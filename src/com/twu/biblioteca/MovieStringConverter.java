package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* Created by ahochoy on 5/5/14.
*/
class MovieStringConverter {


    public List<String> invoke(Collection<Movie> movieList) {
        List<String> movieInformation = new ArrayList<String>();
        for (Movie movie : movieList) {
            movieInformation.add(movie.getMovieInformation());
        }
        return movieInformation;
    }
}
