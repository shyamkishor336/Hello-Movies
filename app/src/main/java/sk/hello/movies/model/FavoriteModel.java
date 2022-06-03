package sk.hello.movies.model;

import java.util.List;

import sk.hello.movies.interfaces.FavoritesInterface;
import sk.hello.movies.utils.FavoritesStore;

public class FavoriteModel implements FavoritesInterface {
    private FavoritesStore favoritesStore;

    public FavoriteModel(FavoritesStore store) {
        favoritesStore = store;
    }

    @Override
    public void setFavorite(Movie movie) {
        favoritesStore.setFavorite(movie);
    }

    @Override
    public boolean isFavorite(String id) {
        return favoritesStore.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites() {
        return favoritesStore.getFavorites();
    }

    @Override
    public void unFavorite(String id) {
        favoritesStore.unfavorite(id);
    }
}
