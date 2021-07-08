package com.release.androidbatch2;

public class MOviewMOdel {

    private String movieName, movieRating , movieDescription;

    public MOviewMOdel(String movieName, String movieRating, String movieDescription) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieDescription = movieDescription;
    }

    public MOviewMOdel() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
