package sk.hello.movies.modules;

import dagger.Module;
import dagger.Provides;
import sk.hello.movies.interfacers.SortingDialogInteractorImpl;
import sk.hello.movies.interfacers.SortingDialogPresenterImpl;
import sk.hello.movies.utils.SortingOptionStore;
import sk.hello.movies.interfaces.SortingDialogInterface;
import sk.hello.movies.interfaces.SortingDialogPresenter;


@Module
public class SortingModule {
    @Provides
    public SortingDialogInterface providesSortingDialogInteractor(SortingOptionStore store) {
        return new SortingDialogInteractorImpl(store);
    }

    @Provides
    public SortingDialogPresenter providePresenter(SortingDialogInterface interactor) {
        return new SortingDialogPresenterImpl(interactor);
    }
}
