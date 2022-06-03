package sk.hello.movies.interfaces;

import sk.hello.movies.utils.SortType;

public interface SortingDialogInterface {
    int getSelectedSortingOption();

    void setSortingOption(SortType sortType);
}
