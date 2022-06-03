package sk.hello.movies;

import dagger.Module;
import dagger.Provides;


@Module
public class SortingModule {
    @Provides
    SortingDialogInteractor providesSortingDialogInteractor(SortingOptionStore store) {
        return new SortingDialogInteractorImpl(store);
    }

    @Provides
    SortingDialogPresenter providePresenter(SortingDialogInteractor interactor) {
        return new SortingDialogPresenterImpl(interactor);
    }
}
