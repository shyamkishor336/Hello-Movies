package sk.hello.movies.interfaces;
import dagger.Subcomponent;
import sk.hello.movies.modules.DetailsModule;
import sk.hello.movies.fragment.MovieDetailsFragment;


@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent {
    void inject(MovieDetailsFragment target);
}
