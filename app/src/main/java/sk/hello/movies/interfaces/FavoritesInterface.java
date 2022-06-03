package sk.hello.movies.interfaces;

import java.util.List;

import sk.hello.movies.model.Movie;

public interface FavoritesInterface {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);
}
