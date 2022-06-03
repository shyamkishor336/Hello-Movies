package sk.hello.movies.modules;


import dagger.Module;
import dagger.Provides;
import sk.hello.movies.interfacers.MoviesListingInterfacer;
import sk.hello.movies.interfacers.MoviesListingPresenter;
import sk.hello.movies.interfaces.MoviesListingInterface;
import sk.hello.movies.utils.SortingOptionStore;
import sk.hello.movies.utils.TmdbWebService;
import sk.hello.movies.interfaces.FavoritesInterface;

@Module
public class ListingModule {
    @Provides
    MoviesListingInterface provideMovieListingInteractor(FavoritesInterface favoritesInterface,
                                                         TmdbWebService tmdbWebService,
                                                         SortingOptionStore sortingOptionStore) {
        return new MoviesListingInterfacer(favoritesInterface, tmdbWebService, sortingOptionStore);
    }

    @Provides
    sk.hello.movies.interfaces.MoviesListingPresenter provideMovieListingPresenter(MoviesListingInterface interactor) {
        return new MoviesListingPresenter(interactor);
    }
}
