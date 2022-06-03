package sk.hello.movies.interfaces;

import dagger.Subcomponent;
import sk.hello.movies.modules.ListingModule;
import sk.hello.movies.fragment.MoviesListingFragment;
import sk.hello.movies.fragment.SortingDialogFragment;
import sk.hello.movies.modules.SortingModule;

@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
