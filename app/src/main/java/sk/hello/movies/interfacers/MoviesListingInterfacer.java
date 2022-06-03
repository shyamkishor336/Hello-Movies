package sk.hello.movies.interfacers;

import androidx.annotation.NonNull;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;
import sk.hello.movies.interfaces.FavoritesInterface;
import sk.hello.movies.interfaces.MoviesListingInterface;
import sk.hello.movies.model.Movie;
import sk.hello.movies.utils.SortType;
import sk.hello.movies.utils.SortingOptionStore;
import sk.hello.movies.utils.TmdbWebService;
import sk.hello.movies.wraper.MoviesWraper;

public class MoviesListingInterfacer implements MoviesListingInterface {
    private FavoritesInterface favoritesInterface;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final int NEWEST_MIN_VOTE_COUNT = 50;

    public MoviesListingInterfacer(FavoritesInterface favoritesInterface,
                                   TmdbWebService tmdbWebService, SortingOptionStore store) {
        this.favoritesInterface = favoritesInterface;
        this.tmdbWebService = tmdbWebService;
        sortingOptionStore = store;
    }


    @Override
    public boolean isPaginationSupported() {
        int selectedOption = sortingOptionStore.getSelectedOption();
        return selectedOption != SortType.FAVORITES.getValue();
    }

    @Override
    public Observable<List<Movie>> fetchMovies(int page) {
        int selectedOption = sortingOptionStore.getSelectedOption();
        if (selectedOption == SortType.MOST_POPULAR.getValue()) {
            return tmdbWebService.popularMovies(page).map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
            return tmdbWebService.highestRatedMovies(page).map(MoviesWraper::getMovieList);
        } else if (selectedOption == SortType.NEWEST.getValue()) {
            Calendar cal = Calendar.getInstance();
            String maxReleaseDate = dateFormat.format(cal.getTime());
            return tmdbWebService.newestMovies(maxReleaseDate, NEWEST_MIN_VOTE_COUNT).map(MoviesWraper::getMovieList);
        } else {
            return Observable.just(favoritesInterface.getFavorites());
        }
    }

    @Override
    public Observable<List<Movie>> searchMovie(@NonNull String searchQuery) {
        return tmdbWebService.searchMovies(searchQuery).map(MoviesWraper::getMovieList);
    }

}
