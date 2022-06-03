package sk.hello.movies.interfaces;

import java.util.List;

import io.reactivex.Observable;
import sk.hello.movies.model.Movie;

public interface MoviesListingInterface {
    boolean isPaginationSupported();

    Observable<List<Movie>> fetchMovies(int page);

    Observable<List<Movie>> searchMovie(String searchQuery);
}
