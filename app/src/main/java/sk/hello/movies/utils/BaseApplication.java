package sk.hello.movies.utils;

import android.app.Application;
import android.os.StrictMode;


import io.realm.Realm;
import sk.hello.movies.interfaces.DetailsComponent;
import sk.hello.movies.modules.DetailsModule;
import sk.hello.movies.modules.FavoritesModule;
import sk.hello.movies.interfaces.ListingComponent;
import sk.hello.movies.modules.ListingModule;
import sk.hello.movies.network.NetworkModule;
import sk.hello.movies.singleton.AppComponent;
import sk.hello.movies.singleton.AppModule;
import sk.hello.movies.singleton.DaggerAppComponent;


public class BaseApplication extends Application {
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm() {
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent() {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent() {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent() {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent() {
        listingComponent = null;
    }

    public ListingComponent getListingComponent() {
        return listingComponent;
    }
}
