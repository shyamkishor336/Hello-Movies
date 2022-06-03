package sk.hello.movies.singleton;

import javax.inject.Singleton;

import dagger.Component;
import sk.hello.movies.interfaces.DetailsComponent;
import sk.hello.movies.modules.DetailsModule;
import sk.hello.movies.modules.FavoritesModule;
import sk.hello.movies.interfaces.ListingComponent;
import sk.hello.movies.modules.ListingModule;
import sk.hello.movies.network.NetworkModule;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent {
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
