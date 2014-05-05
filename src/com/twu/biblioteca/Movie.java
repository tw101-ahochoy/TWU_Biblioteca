package com.twu.biblioteca;

public class Movie {
    private final String title;
    private final String year;
    private final String director;
    private final String rating;

    public Movie(String title, String year, String director, String rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getMovieInformation() {
        return title + ", " + year + ", " + director + ", " + rating;
    }
}
