package sk.hello.movies.interfacers;

import sk.hello.movies.interfaces.SortingDialogInterface;
import sk.hello.movies.interfaces.SortingDialogPresenter;
import sk.hello.movies.interfaces.SortingDialogView;
import sk.hello.movies.utils.SortType;

public class SortingDialogPresenterImpl implements SortingDialogPresenter {
    private SortingDialogView view;
    private SortingDialogInterface sortingDialogInterface;

    public SortingDialogPresenterImpl(SortingDialogInterface interactor) {
        sortingDialogInterface = interactor;
    }

    @Override
    public void setView(SortingDialogView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
    }

    @Override
    public void setLastSavedOption() {
        if (isViewAttached()) {
            int selectedOption = sortingDialogInterface.getSelectedSortingOption();

            if (selectedOption == SortType.MOST_POPULAR.getValue()) {
                view.setPopularChecked();
            } else if (selectedOption == SortType.HIGHEST_RATED.getValue()) {
                view.setHighestRatedChecked();
            } else if (selectedOption == SortType.NEWEST.getValue()) {
                view.setNewestChecked();
            } else {
                view.setFavoritesChecked();
            }
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void onPopularMoviesSelected() {
        if (isViewAttached()) {
            sortingDialogInterface.setSortingOption(SortType.MOST_POPULAR);
            view.dismissDialog();
        }
    }

    @Override
    public void onHighestRatedMoviesSelected() {
        if (isViewAttached()) {
            sortingDialogInterface.setSortingOption(SortType.HIGHEST_RATED);
            view.dismissDialog();
        }
    }

    @Override
    public void onNewestMoviesSelected() {
        if (isViewAttached()) {
            sortingDialogInterface.setSortingOption(SortType.NEWEST);
            view.dismissDialog();
        }
    }

    @Override
    public void onFavoritesSelected() {
        if (isViewAttached()) {
            sortingDialogInterface.setSortingOption(SortType.FAVORITES);
            view.dismissDialog();
        }
    }
}
