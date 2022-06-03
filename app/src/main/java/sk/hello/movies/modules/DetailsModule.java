package sk.hello.movies.modules;



import dagger.Module;
import dagger.Provides;
import sk.hello.movies.interfaces.MovieDetailsInterface;
import sk.hello.movies.interfaces.FavoritesInterface;
import sk.hello.movies.interfaces.DetailsScope;
import sk.hello.movies.interfacers.MovieDetailsInterfacer;
import sk.hello.movies.interfacers.MovieDetailsPresenter;
import sk.hello.movies.utils.TmdbWebService;


@Module
public class DetailsModule {
    @Provides
    @DetailsScope
    MovieDetailsInterface provideInteractor(TmdbWebService tmdbWebService) {
        return new MovieDetailsInterfacer(tmdbWebService);
    }

    @Provides
    @DetailsScope
    sk.hello.movies.interfaces.MovieDetailsPresenter providePresenter(MovieDetailsInterface detailsInteractor,
                                                                      FavoritesInterface favoritesInterface) {
        return new MovieDetailsPresenter(detailsInteractor, favoritesInterface);
    }
}
