package sk.hello.movies.interfacers;

import sk.hello.movies.interfaces.SortingDialogInterface;
import sk.hello.movies.utils.SortType;
import sk.hello.movies.utils.SortingOptionStore;

public class SortingDialogInterfacer implements SortingDialogInterface {
    private SortingOptionStore sortingOptionStore;

    public SortingDialogInterfacer(SortingOptionStore store) {
        sortingOptionStore = store;
    }

    @Override
    public int getSelectedSortingOption() {
        return sortingOptionStore.getSelectedOption();
    }

    @Override
    public void setSortingOption(SortType sortType) {
        sortingOptionStore.setSelectedOption(sortType);
    }
}
