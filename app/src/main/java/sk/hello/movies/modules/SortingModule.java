package sk.hello.movies.modules;

import dagger.Module;
import dagger.Provides;
import sk.hello.movies.interfacers.SortingDialogInterfacer;
import sk.hello.movies.interfacers.SortingDialogPresenter;
import sk.hello.movies.utils.SortingOptionStore;
import sk.hello.movies.interfaces.SortingDialogInterface;


@Module
public class SortingModule {
    @Provides
    public SortingDialogInterface providesSortingDialogInteractor(SortingOptionStore store) {
        return new SortingDialogInterfacer(store);
    }

    @Provides
    public sk.hello.movies.interfaces.SortingDialogPresenter providePresenter(SortingDialogInterface interactor) {
        return (sk.hello.movies.interfaces.SortingDialogPresenter) new SortingDialogPresenter(interactor);
    }
}
