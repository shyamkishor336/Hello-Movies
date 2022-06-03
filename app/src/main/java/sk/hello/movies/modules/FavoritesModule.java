package sk.hello.movies.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sk.hello.movies.utils.FavoritesStore;
import sk.hello.movies.interfaces.FavoritesInterface;

import sk.hello.movies.model.FavoriteModel;
import sk.hello.movies.singleton.AppModule;


@Module(includes = AppModule.class)
public class FavoritesModule {
    @Provides
    @Singleton
    FavoritesInterface provideFavouritesInteractor(FavoritesStore store) {
        return new FavoriteModel(store);
    }
}
