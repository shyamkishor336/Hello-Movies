package sk.hello.movies.modules;


import dagger.Module;
import dagger.Provides;
import sk.hello.movies.interfacers.MoviesListingInteractorImpl;
import sk.hello.movies.interfacers.MoviesListingPresenterImpl;
import sk.hello.movies.interfaces.MoviesListingInterface;
import sk.hello.movies.interfaces.MoviesListingPresenter;
import sk.hello.movies.utils.SortingOptionStore;
import sk.hello.movies.utils.TmdbWebService;
import sk.hello.movies.interfaces.FavoritesInterface;

@Module
public class ListingModule {
    @Provides
    MoviesListingInterface provideMovieListingInteractor(FavoritesInterface favoritesInterface,
                                                         TmdbWebService tmdbWebService,
                                                         SortingOptionStore sortingOptionStore) {
        return new MoviesListingInteractorImpl(favoritesInterface, tmdbWebService, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInterface interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
