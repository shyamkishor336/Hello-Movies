package sk.hello.movies.modules;



import dagger.Module;
import dagger.Provides;
import sk.hello.movies.interfaces.MovieDetailsInterface;
import sk.hello.movies.interfaces.FavoritesInterface;
import sk.hello.movies.interfaces.DetailsScope;
import sk.hello.movies.interfacers.MovieDetailsInteractorImpl;
import sk.hello.movies.interfaces.MovieDetailsPresenter;
import sk.hello.movies.interfacers.MovieDetailsPresenterImpl;
import sk.hello.movies.utils.TmdbWebService;


@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInterface provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInterface detailsInteractor,
                                           FavoritesInterface favoritesInterface) {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInterface);
    }
}
