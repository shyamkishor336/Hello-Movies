package sk.hello.movies.interfaces;

import java.util.List;

import sk.hello.movies.model.Movie;

public interface MoviesListingView {
    void showMovies(List<Movie> movies);

    void loadingStarted();

    void loadingFailed(String errorMessage);

    void onMovieClicked(Movie movie);
}
