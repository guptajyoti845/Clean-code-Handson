package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int amount() {
        return movie.calculateAmount(this.daysRented);
    }

    public boolean isMovieRelease() {
        return (movie.isMovieRelease());
    }

    public boolean isDaysRentedGreaterThanOne() {
        return (this.daysRented > 1);
    }

    public String findResult(double thisAmount) {
        return this.movie.findResult(thisAmount);
    }
}
