package sk.hello.movies;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesListingInteractor {
    boolean isPaginationSupported();

    Observable<List<Movie>> fetchMovies(int page);

    Observable<List<Movie>> searchMovie(String searchQuery);
}
